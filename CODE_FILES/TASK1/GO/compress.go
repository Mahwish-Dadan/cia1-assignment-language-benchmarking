package main

import (
    "compress/gzip"
    "io"
    "os"
    "time"
)

func main() {
    start := time.Now()

    inputFile, _ := os.Open("input.txt")
    defer inputFile.Close()

    outputFile, _ := os.Create("outputgo.txt.gz")
    defer outputFile.Close()

    writer := gzip.NewWriter(outputFile)
    defer writer.Close()

    io.Copy(writer, inputFile)

    elapsed := time.Since(start)
    println("Time taken:", elapsed.Milliseconds(), "ms")
}
