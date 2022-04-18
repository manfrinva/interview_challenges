package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func main() {
	size := 999999 //variable to determine the array size
	exampleArray := createAndPopulateArray(size)

	//Finding the maximum and minimum values with different methods.
	loopingThroughArray(exampleArray)
	sortingArray(exampleArray)

}

func sortingArray(arr []int) {
	start := time.Now()
	//If you sort the array, just get the value of the first position [0] and the last position
	sort.Ints(arr)
	minValue := arr[0]
	maxValue := arr[(len(arr) - 1)] //You need to subtract 1 because the array starts at 0

	//show values
	fmt.Println("Max Value", maxValue)
	fmt.Println("Min Value", minValue)

	//compare time
	end := time.Since(start)
	fmt.Println("Execution Time: ", end)
}

func loopingThroughArray(arr []int) {
	start := time.Now()
	//using a Method to range the array and select the min and max values.
	//The problem in this case is that the larger the array, the longer the execution time and the greater the demand for resources.
	minValueWithMethod := findMin(arr)
	maxValueWithMethod := findMax(arr)

	//show Values
	fmt.Println("Max Value", minValueWithMethod)
	fmt.Println("Min Value", maxValueWithMethod)

	//compare time
	end := time.Since(start)
	fmt.Println("Execution Time: ", end)
}

func findMin(a []int) int {
	min := a[0]
	for _, value := range a {
		if value < min {
			min = value
		}
	}
	return min
}

func findMax(a []int) int {
	max := a[0]
	for _, value := range a {

		if value > max {
			max = value
		}
	}
	return max
}

func createAndPopulateArray(size int) []int {
	arr := make([]int, 0)
	for i := 0; i < size; i++ {
		arr = append(arr, rand.Intn(1000000))
	}
	return arr
}
