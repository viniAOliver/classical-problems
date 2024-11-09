package reader_writer

import (
	"sync"
	"time"
)

func StartWriter(sharedData *SharedData, id int, value int, wg *sync.WaitGroup) {
	defer wg.Done()
	time.Sleep(1 * time.Second) // Adiciona uma espera antes de iniciar a escrita
	sharedData.Write(id, value)
}
