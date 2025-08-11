package main

import (
    "bufio"
    "fmt"
    "os"
    "strings"
    "time"
)

func main() {
    start := time.Now()
    file, _ := os.Open("input.txt")
    defer file.Close()

    scanner := bufio.NewScanner(file)
    count := 0

    for scanner.Scan() {
        if strings.Contains(scanner.Text(), "data") {
            count++
        }
    }

    fmt.Println("Lines containing 'data':", count)
    fmt.Println("Time taken:", time.Since(start).Milliseconds(), "ms")
   

    time.Sleep(3 * time.Second) // Waits for 30 seconds
}
