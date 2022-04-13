'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}


/*
 * Complete the 'performWarehouseQueries' function below.
 *
 * The function is expected to return a 2D_STRING_ARRAY.
 * The function accepts 2D_STRING_ARRAY query as parameter.
 */

class Queue{
    constructor(){
        this.items = [];
    }
    
    enqueue = (ele) =>{
        this.items.push(ele);
    }
    
    dequeue = () =>{
        if(this.isEmpty()){
            return 'Empty';
        }
        return this.items.shift();
    }
    size = () =>{
        return this.items.length;
    }
    
    isEmpty = ()=>{
        return this.size()===0;
    }
    
    get allItems(){
        return this.items;
    }
}

function performWarehouseQueries(query) {
    if((query == null)||(query.size == 0)){
        return null;
    }
    else{
        let result = [];
        const masterQueue = new Queue();
        let orderQueue = new Queue();
        
        query.forEach(
            ([queryType, code])=>{
                if(queryType === 'INSERT'){
                    orderQueue.enqueue(code);
                    if(orderQueue.size()>=3){
                        masterQueue.enqueue(orderQueue);
                        orderQueue = new Queue();
                    }
                }
                if(queryType === 'SHIP'){
                    if(masterQueue.isEmpty()){
                        result.push(['NA']);
                    } else{
                        result.push(masterQueue.dequeue().allItems);
                    }
                }
            });
        
        return result;
    }
}
function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const queryRows = parseInt(readLine().trim(), 10);

    const queryColumns = parseInt(readLine().trim(), 10);

    let query = Array(queryRows);

    for (let i = 0; i < queryRows; i++) {
        query[i] = readLine().replace(/\s+$/g, '').split(' ');
    }

    const result = performWarehouseQueries(query);

    ws.write(result.map(x => x.join(' ')).join('\n') + '\n');

    ws.end();
}
