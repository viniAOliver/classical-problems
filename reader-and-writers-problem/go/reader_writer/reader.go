package reader_writer

import "sync"

func StartReader(sharedData *SharedData, id int, wg *sync.WaitGroup) {
	defer wg.Done()
	sharedData.rwLock.RLock()
	defer sharedData.rwLock.RUnlock()
	sharedData.Read(id)
}
