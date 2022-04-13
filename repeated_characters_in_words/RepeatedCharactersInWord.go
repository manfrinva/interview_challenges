package main

import (
	"fmt"
	"strings"
)

func main() {
	str := "Interview"		//Word to use
	chars := strings.Split(str, "")	//Breaking the string into an array of chars
	reptitionMax := 2		//Maximum number of repetitions
	count := 0

	m := make(map[string]int)	//Creating a map with each letter as key a and repetition as value

  //For to loop through all chars
  for i := 0; i < len(chars); i++ {
		key := chars[i]
		count = strings.Count(str, key)
		m[key] = count
	}

  //For show all the repetitions
	for key, value := range m {
		if value >= reptitionMax  {
			fmt.Println("Letter: ", key, "Repetition: ", value)
		}
	}
}
