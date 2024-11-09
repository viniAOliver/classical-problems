package main

import (
	"fmt"
	"reader-and-writers-problem/go/reader_writer"
	"sync"
)

func main() {
	fmt.Println("Programa iniciado")
	var wg sync.WaitGroup
	sharedData := &reader_writer.SharedData{Data: 0}

	for i := 1; i <= 5; i++ {
		wg.Add(1)
		go reader_writer.StartReader(sharedData, i, &wg)
	}

	for i := 1; i <= 2; i++ {
		wg.Add(1)
		go reader_writer.StartWriter(sharedData, i, i*10, &wg)
	}

	wg.Wait()
	fmt.Println("Programa finalizado")
}
