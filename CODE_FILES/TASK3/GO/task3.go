package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())
	data := make([]int, 1_000_000)
	for i := range data {
		data[i] = rand.Intn(1_000_001)
	}

	start := time.Now()

	sort.Ints(data)
	found := 0

	for i := 0; i < 1000; i++ {
		target := rand.Intn(1_000_001)
		index := sort.SearchInts(data, target)
		if index < len(data) && data[index] == target {
			found++
		}
	}

	elapsed := time.Since(start)
	fmt.Printf("Found %d values.\n", found)
	fmt.Printf("Time taken: %d ms\n", elapsed.Milliseconds())

    	// Adding time to see it in Process Explorer
    	time.Sleep(3 * time.Second)
}
