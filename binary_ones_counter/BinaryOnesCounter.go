package main

import (
	"fmt"
	"strconv"
)

func main() {
	var a = 10
	var b = 15
	var bin = "" + IntegerToBinary(a, b)
	var result = BinaryOnesCounter(bin)
	fmt.Println(result)
}

func IntegerToBinary(a, b int) string {
	if (a > 0 && a < 1000000000) && (b > 0 && b < 1000000000) {
		n := a + b
		return strconv.FormatInt(int64(n), 2)
	} else {
		return "0"
	}
}

func BinaryOnesCounter(s string) int {
	res := ""
	chars := []rune(s)
	for i := 0; i < len(chars); i++ {
		if chars[i] == '1' {
			res = res + "1"
		}
	}

	var number, error = strconv.Atoi(res)
	if number > 0 && error == nil {
		return number
	} else {
		return 0
	}
}
