# Classical Problems in Operating Systems

## Author
- [José Vinicius Alves de Oliveira](https://github.com/viniAOliver)

## Overview

This repository contains implementations of classic synchronization problems in operating systems, based on Chapter 12 of *Sistemas Operacionais: Conceitos e Mecanismos* by Carlos A. Maziero (2019). The goal is to provide summaries and practical code implementations for each problem discussed in the chapter.

### Problems Implemented
1. **Bounded Buffer Problem (Producer/Consumer)**
2. **Dining Savages Problem**
3. **Dining Philosophers Problem**
4. **Readers and Writers Problem**

---

### 1. Producer/Consumer (Bounded Buffer Problem)

**Description:**  
The Bounded Buffer Problem, also known as the Producer/Consumer Problem, was introduced by Mordechai Ben-Ari in *Principles of Concurrent and Distributed Programming* (1983). This problem involves a buffer shared between multiple producer and consumer threads, with mutual exclusion and synchronization requirements.

- **Buffer:** Stores `N` items.
- **Producer:** Adds items to the buffer.
- **Consumer:** Removes items from the buffer.
- **Synchronization:**  
  - Producers must wait when the buffer is full.
  - Consumers must wait when the buffer is empty.
  - Mutual exclusion ensures no conflicts between producers and consumers accessing the buffer.

**Code:**  
The Java implementation is available in the `bounded-buffer-problem/java` directory.  
[View on GitHub](https://github.com/viniAOliver/classical-problems/tree/main/bounded-buffer-problem/java)

---

### 2. Dining Savages Problem

**Description:**  
A variation of the Bounded Buffer Problem, the Dining Savages Problem was introduced by Gregory Andrews in *Concurrent Programming: Principles and Practice* (1991). It represents a situation with a limited amount of food (buffer) shared among consumers (savages) and filled by a producer (cook).

- **Caldeirão (Pot):** Stores `N` meals shared among savages.
- **Cozinheiro (Cook):** Refills the pot when empty.
- **Selvagem (Savage):** Consumes one meal per access, refilling only when the pot is empty.

**Code:**  
The Ruby implementation is available in the `dining-savages-problem/ruby` directory.  
[View on GitHub](https://github.com/viniAOliver/classical-problems/tree/main/dining-savages-problem/ruby)

---

### 3. Dining Philosophers Problem

**Description:**  
The Dining Philosophers Problem, formulated in 1965 by Edsger W. Dijkstra and later refined by C.A.R. Hoare, describes a scenario where five philosophers must share five forks. Each philosopher needs two forks to eat, which leads to a challenge in managing access to the limited resources without deadlock or starvation.

**Code:**  
The C# implementation is available in the `dining-philosophers-problem/csharp` directory.  
[View on GitHub](https://github.com/viniAOliver/classical-problems/tree/main/dining-philosophers-problem/csharp)

---

### 4. Readers and Writers Problem

**Description:**  
Presented by Courtois et al. in 1971, the Readers and Writers Problem involves managing access to shared resources, prioritizing reader processes to avoid unnecessary waiting, while ensuring writers have sufficient access when required.

- **Problem 1:** Reader priority implementation where readers can access freely unless a writer is writing.
  
**Code:**  
The Go implementation, prioritizing readers, is available in the `reader-and-writers-problem/go` directory.  
[View on GitHub](https://github.com/viniAOliver/classical-problems/tree/main/reader-and-writers-problem/go)

---

## References

- MAZIERO, Carlos A. *Sistemas operacionais: conceitos e mecanismos*. Livro Aberto, 2014.
- BEN-ARI, Mordechai. *Principles of Concurrent and Distributed Programming*, 1983.
- ANDREWS, Gregory R. *Concurrent programming: principles and practice*. Benjamin-Cummings Publishing Co., 1991.
- COURTOIS, Pierre-Jacques; HEYMANS, Frans; PARNAS, David Lorge. *Concurrent control with “readers” and “writers”*. Communications of the ACM, 1971.
