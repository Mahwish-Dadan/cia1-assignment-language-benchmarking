package main

import (
    "fmt"
    "math/rand"
    "time"
)

const SIZE = 500

func main() {
    rand.Seed(time.Now().UnixNano())

    A := make([][]int, SIZE)
    B := make([][]int, SIZE)
    C := make([][]int, SIZE)
    for i := 0; i < SIZE; i++ {
        A[i] = make([]int, SIZE)
        B[i] = make([]int, SIZE)
        C[i] = make([]int, SIZE)
        for j := 0; j < SIZE; j++ {
            A[i][j] = rand.Intn(11)
            B[i][j] = rand.Intn(11)
        }
    }

    start := time.Now()

    for i := 0; i < SIZE; i++ {
        for j := 0; j < SIZE; j++ {
            for k := 0; k < SIZE; k++ {
                C[i][j] += A[i][k] * B[k][j]
            }
        }
    }

    elapsed := time.Since(start)

    sum := 0
    for i := 0; i < SIZE; i++ {
        for j := 0; j < SIZE; j++ {
            sum += C[i][j]
        }
    }

    fmt.Println("Sum of elements:", sum)
    fmt.Printf("Time taken: %d ms\n", elapsed.Milliseconds())

}
