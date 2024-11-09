package reader_writer

import (
	"fmt"
	"sync"
	"time"
)

type SharedData struct {
	Data       int
	rwLock     sync.RWMutex
	readers    int
	readersMux sync.Mutex
}

func (s *SharedData) Read(id int) {
	s.readersMux.Lock()
	s.readers++
	if s.readers == 1 {
		s.rwLock.RLock()
	}
	s.readersMux.Unlock()

	fmt.Printf("Leitor %d: iniciando leitura\n", id)
	fmt.Printf("Leitor %d: lendo valor %d\n", id, s.Data)
	time.Sleep(2 * time.Second)
	fmt.Printf("Leitor %d: terminou de ler\n", id)

	s.readersMux.Lock()
	s.readers--
	if s.readers == 0 {
		s.rwLock.RUnlock()
	}
	s.readersMux.Unlock()
}

func (s *SharedData) Write(id int, value int) {
	fmt.Printf("Escritor %d: iniciando escrita\n", id)
	s.rwLock.Lock()
	fmt.Printf("Escritor %d: escrevendo valor %d\n", id, value)
	s.Data = value
	time.Sleep(3 * time.Second)
	s.rwLock.Unlock()
	fmt.Printf("Escritor %d: terminou de escrever\n", id)
}
