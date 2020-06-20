package main

import (
	"fmt"
)

type Window struct {
    Height  int
    Width int
}

func multiplyStuff(x int, y int) int {

	return x*y;
}

func (p *Window) CalculateWindowSize() int {
	windowSize := p.Height * p.Width

	return windowSize
}

func IfElseFunction(x int) string {

	if x<5{
		return fmt.Sprintf("sda")
	}

	return fmt.Sprintf("default return statement")
}

func main() {

	// in millimeters
	var windowHeight = 1100
	var windowWidth = 750

	var windowSize = windowHeight * windowWidth

	fmt.Println("Window Size: ", windowSize)
	fmt.Println("Result of multiplication is: ", multiplyStuff(5,6));

	windowOne := Window{Height: 100, Width:50};
	windowTwo := Window{Height: 100, Width:50};
	fmt.Println("Window size through structs is ", windowOne.Height * windowOne.Width)

	fmt.Println("Return value of func is ", windowOne.CalculateWindowSize() + windowTwo.CalculateWindowSize());

	fmt.Println("if else is : "+ IfElseFunction(6))
}