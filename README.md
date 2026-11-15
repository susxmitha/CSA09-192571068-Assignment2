# CSA09 – PROGRAMMING IN JAVA
## ASSIGNMENT 2 | CO2

### Java Collection Framework, Performance Analysis and Object-Oriented Programming

---

## 1. STUDENT AND COURSE DETAILS

| Particulars | Details |
|---|---|
| Course Name | Programming in Java |
| Course Code | CSA09 |
| Assignment | Assignment 2 |
| Course Outcome | CO2 |
| Student Name | S Susmitha |
| Student Register Number | 192571068 |
| Institution | SIMATS Engineering, Saveetha Institute of Medical and Technical Sciences |
| Programming Language | Java |
| Repository Name | CSA09-192571068-Assignment2 |

---

## 2. PROJECT DESCRIPTION

This repository contains the implementation, experimental evaluation and performance analysis of seven Java programming tasks under Assignment 2 (CO2).

The assignment focuses on understanding Java programming concepts, evaluating the performance of different data structures, implementing appropriate algorithms and making evidence-based engineering decisions.

The programs explore String handling, Java Collections, object equality, hashing, Map implementations, Generics, Comparator-based sorting, PriorityQueue and performance optimisation.

The assignment follows the prescribed problem-solving methodology:

**PREDICT → DESIGN → IMPLEMENT → MEASURE → ANALYSE → EVALUATE → DIAGNOSE → REDESIGN → VALIDATE**

Each task includes its Java source code and supporting execution evidence. Timed benchmark tasks additionally include three captured executions and their corresponding raw console outputs.

---

## 3. OBJECTIVES

The primary objectives of this assignment are:

1. Compare String, StringBuilder and StringBuffer in terms of execution performance and memory behaviour.
2. Analyse ArrayList and LinkedList under different collection operations and input sizes.
3. Demonstrate the equals() and hashCode() contract and its importance in Java collections.
4. Compare HashMap, TreeMap and LinkedHashMap for medicine inventory lookup and iteration.
5. Implement a generic leaderboard using Comparator and multiple ranking conditions.
6. Develop a hospital triage system using PriorityQueue with severity-based priority and FIFO tie-breaking.
7. Identify a collection-performance bottleneck, redesign the implementation and validate the improvement experimentally.

---

## 4. REPOSITORY STRUCTURE

```text
CSA09-192571068-Assignment2/
│
├── README.md
│
├── Report_Charts/
│   ├── Q4_lookup_comparison.png
│   ├── Q6_priority_queue_growth.png
│   └── Q7_front_operation_comparison.png
│
├── Task01/
│   ├── Q1.java
│   └── evidence/
│       ├── Q1_trial1.txt
│       ├── Q1_trial2.txt
│       ├── Q1_trial3.txt
│       ├── README.txt
│       ├── Task01-Part1.png
│       ├── Task01-Part2.png
│       ├── Task01-Part3.png
│       └── Task01_CMD_Evidence.png
│
├── Task02/
│   ├── Q2.java
│   └── evidence/
│       ├── Q2_trial1.txt
│       ├── Q2_trial2.txt
│       ├── Q2_trial3.txt
│       ├── README.txt
│       ├── Task02-Part1.png
│       ├── Task02-Part2.png
│       ├── Task02-Part3.png
│       └── Task02_CMD_Evidence.png
│
├── Task03/
│   ├── Q3.java
│   └── evidence/
│       ├── Q3_trial1.txt
│       ├── README.txt
│       ├── Task03(1).png
│       └── Task03_CMD_Evidence.png
│
├── Task04/
│   ├── Q4.java
│   └── evidence/
│       ├── Q4_trial1.txt
│       ├── Q4_trial2.txt
│       ├── Q4_trial3.txt
│       ├── README.txt
│       ├── Task04-Part1.png
│       ├── Task04-Part2.png
│       ├── Task04-Part3.png
│       └── Task04_CMD_Evidence.png
│
├── Task05/
│   ├── Q5.java
│   └── evidence/
│       ├── Q5_trial1.txt
│       ├── README.txt
│       ├── Task05(1).png
│       └── Task05_CMD_Evidence.png
│
├── Task06/
│   ├── Q6.java
│   └── evidence/
│       ├── Q6_trial1.txt
│       ├── Q6_trial2.txt
│       ├── Q6_trial3.txt
│       ├── README.txt
│       ├── Task06-Part1.png
│       ├── Task06-Part2.png
│       ├── Task06-Part3.png
│       └── Task06_CMD_Evidence.png
│
└── Task07/
    ├── Q7.java
    └── evidence/
        ├── Q7_trial1.txt
        ├── Q7_trial2.txt
        ├── Q7_trial3.txt
        ├── README.txt
        ├── Task07-Part1.png
        ├── Task07-Part2.png
        ├── Task07-Part3.png
        └── Task07_CMD_Evidence.png
```

---

# 5. QUESTION-WISE IMPLEMENTATION

## Q1 – STRING vs STRINGBUILDER vs STRINGBUFFER

**Objective:** Compare the execution performance and memory behaviour of different Java string-construction techniques.

### Implementations
- String concatenation using the `+` operator.
- StringBuilder for mutable string construction.
- StringBuffer for synchronized mutable string construction.

### Experimental workloads

| Number of Fields | Ticket Operations |
|---:|---:|
| 6 | 1 |
| 50 | 10,000 |
| 200 | 2,000 |

### Measurements
- Execution time per ticket in nanoseconds.
- Heap-memory snapshots before and after execution.
- Estimated intermediate string creation.
- Performance comparison between the three approaches.

### Engineering observation

StringBuilder is recommended for repeated string construction in a thread-confined context. StringBuffer provides synchronized methods, while repeated String concatenation can generate additional intermediate String objects.

---

## Q2 – ARRAYLIST vs LINKEDLIST

**Objective:** Evaluate the performance of ArrayList and LinkedList under different collection operations.

### Operations evaluated
- Appending elements.
- Front insertion and removal.
- Middle insertion and removal.
- Indexed middle-element access.
- Collection iteration.

### Input sizes

| Collection Size |
|---:|
| 1,000 |
| 10,000 |
| 30,000 |

### Engineering observation

ArrayList provides efficient indexed access and is suitable for general-purpose list operations. LinkedList can be useful for insertion and removal when the relevant node position is already available.

For a queue requiring frequent operations at both ends, ArrayDeque is a suitable alternative because it does not require indexed access.

---

## Q3 – EQUALS() AND HASHCODE() CONTRACT

**Objective:** Demonstrate the relationship between equals() and hashCode() and understand their importance in hash-based collections.

### Implementations and tests
- Comparison of distinct student objects.
- Deliberately incorrect equals()/hashCode() implementation.
- Corrected equals() and hashCode() implementation.
- HashSet behaviour.
- TreeSet behaviour.
- HashMap behaviour.

### Engineering observation

If two objects are equal according to equals(), they must return the same hash code.

A broken hashCode() implementation can cause logically duplicate objects to behave unexpectedly in hash-based collections.

Fields used for equality and hashing should preferably remain immutable while objects are stored in hash-based collections.

**Note:** The exact result of the deliberately broken HashSet demonstration is not guaranteed because the incorrect class does not override hashCode().

---

## Q4 – HASHMAP vs TREEMAP vs LINKEDHASHMAP

**Objective:** Compare different Map implementations for a medicine inventory lookup system.

### Implementations
- HashMap.
- TreeMap.
- LinkedHashMap.

### Experimental parameters

| Parameter | Value |
|---|---:|
| Medicine records | 100 |
| Medicine records | 1,000 |
| Medicine records | 10,000 |
| Lookup operations | 100,000 |

### Measurements
- Lookup execution time.
- Iteration execution time.
- Key-order behaviour.

### Engineering observation

| Map Implementation | Main Characteristic |
|---|---|
| HashMap | Average O(1) lookup; no guaranteed iteration order |
| TreeMap | O(log n) lookup; sorted key order |
| LinkedHashMap | Average O(1) lookup; predictable insertion order |

The choice of Map implementation depends on lookup requirements and whether sorted or insertion-order iteration is required.

---

## Q5 – GENERIC LEADERBOARD USING COMPARATOR

**Objective:** Develop a reusable generic leaderboard that ranks teams using multiple comparison conditions.

### Ranking conditions

1. Higher points receive higher priority.
2. Higher goal difference breaks a points tie.
3. Alphabetical team name breaks the remaining tie.

### Java concepts demonstrated
- Generics.
- Comparator.
- Custom object sorting.
- Multiple comparison conditions.
- Reusable leaderboard implementation.
- Wildcard comparator type `Comparator<? super T>`.

### Engineering observation

Comparator allows ranking logic to be defined separately from the data class. This makes the leaderboard reusable and supports flexible ranking requirements without modifying the underlying object representation.

---

## Q6 – HOSPITAL TRIAGE SYSTEM USING PRIORITYQUEUE

**Objective:** Implement a priority-based hospital patient management system.

### Priority rules

- Severity 1 represents the highest priority.
- Severity 5 represents the lowest priority.
- Patients with equal severity are processed in FIFO arrival order.

### Implementation
- PriorityQueue for patient scheduling.
- Comparator for severity-based ordering.
- Arrival counter for FIFO tie-breaking.
- Priority-based patient removal.

### Experimental input sizes

| Number of Patients |
|---:|
| 1,000 |
| 10,000 |
| 50,000 |

### Measurements
- Queue insertion time.
- Complete removal time.
- Treatment-order validation.

### Engineering observation

PriorityQueue provides efficient priority-based insertion and removal.

The secondary arrival-order criterion preserves FIFO behaviour among patients with equal severity.

A real hospital deployment would also require clinical validation, fairness policies and consideration of starvation.

---

## Q7 – BOTTLENECK DIAGNOSIS, REDESIGN AND VALIDATION

**Objective:** Identify an inefficient collection operation, redesign the implementation and validate the improvement through repeated measurements.

### Initial implementation
ArrayList.

### Identified bottleneck
Repeated insertion and removal at the beginning of an ArrayList requires shifting existing elements.

This results in O(n) movement work for each front operation.

### Redesigned implementation
ArrayDeque.

### Reason for redesign
- ArrayList shifts elements during front insertion and removal.
- ArrayDeque uses a circular-array structure.
- Operations at either end are amortized O(1).

### Experimental input sizes

| Collection Size |
|---:|
| 1,000 |
| 10,000 |
| 50,000 |

### Validation

Three executions were captured for each benchmark program. The mean execution times were calculated to compare the original and redesigned implementations.

### Engineering observation

ArrayDeque significantly reduces the cost of repeated front insertion and removal for this workload.

However, ArrayDeque does not support indexed access. ArrayList remains appropriate when random-access operations are important.

---

# 6. EXPERIMENTAL METHODOLOGY

The timed questions use repeated program executions to evaluate performance rather than relying on a single measurement.

### Benchmark execution coverage

| Question | Experimental Focus | Captured Executions |
|---|---|---:|
| Q1 | String construction performance | 3 |
| Q2 | List operation performance | 3 |
| Q3 | equals() and hashCode() correctness | 1 |
| Q4 | Map lookup and iteration performance | 3 |
| Q5 | Generic leaderboard correctness | 1 |
| Q6 | PriorityQueue performance | 3 |
| Q7 | ArrayList vs ArrayDeque redesign | 3 |

Q3 and Q5 are correctness demonstrations rather than timed benchmark programs.

### Statistical analysis

For Q1, Q2, Q4, Q6 and Q7, the report uses the arithmetic mean and sample standard deviation across three captured executions.

Arithmetic mean:

\[
\bar{x}=\frac{x_1+x_2+x_3}{3}
\]

Sample standard deviation:

\[
s=\sqrt{\frac{\sum_{i=1}^{3}(x_i-\bar{x})^2}{3-1}}
\]

### Measurement limitations

- JVM warm-up and JIT compilation may influence execution time.
- Garbage collection can affect measured performance.
- CPU scheduling and background processes can introduce variability.
- Heap-memory readings are approximate snapshots, not exact allocation counts.
- Results depend on the execution environment.

The measurements are interpreted as experimental observations and should not be treated as universal performance guarantees.

---

# 7. KEY EXPERIMENTAL FINDINGS

| Question | Key Finding |
|---|---|
| Q1 | StringBuilder is efficient for repeated string construction. |
| Q2 | ArrayList supports efficient indexed access; LinkedList has different insertion/removal trade-offs. |
| Q3 | Correct equals() and hashCode() implementations are essential for hash-based collections. |
| Q4 | Map selection depends on lookup performance and iteration-order requirements. |
| Q5 | Comparator supports flexible multi-condition ranking. |
| Q6 | PriorityQueue supports severity-based scheduling with FIFO tie-breaking. |
| Q7 | ArrayDeque reduces front-operation cost compared with ArrayList. |

## Q7 – REDESIGN PERFORMANCE COMPARISON

The three-run mean measurements produced the following improvements:

| Collection Size | ArrayDeque Improvement |
|---:|---:|
| 1,000 | 76.18% |
| 10,000 | 95.70% |
| 50,000 | 98.99% |

These measurements support the redesign for workloads dominated by front insertion and removal.

The comparison graph is available in:

`Report_Charts/Q7_front_operation_comparison.png`

---

# 8. SOFTWARE REQUIREMENTS

| Component | Requirement |
|---|---|
| Programming Language | Java |
| JDK | Java 8 or later |
| IDE / Editor | Visual Studio Code or any Java-compatible IDE |
| Terminal | Windows Command Prompt / VS Code Terminal |
| Version Control | Git |
| Repository Hosting | GitHub |

The programs use standard Java libraries and do not require external dependencies.

Verify the Java installation:

```bash
java -version
javac -version
```

---

# 9. COMPILATION AND EXECUTION

All programs can be compiled and executed independently from the repository root.

### Windows Command Prompt

**Q1 – String Performance**

```bat
javac Task01\Q1.java
java -cp Task01 Q1
```

**Q2 – Collection Comparison**

```bat
javac Task02\Q2.java
java -cp Task02 Q2
```

**Q3 – equals() and hashCode()**

```bat
javac Task03\Q3.java
java -cp Task03 Q3
```

**Q4 – Map Comparison**

```bat
javac Task04\Q4.java
java -cp Task04 Q4
```

**Q5 – Generic Leaderboard**

```bat
javac Task05\Q5.java
java -cp Task05 Q5
```

**Q6 – Hospital Triage**

```bat
javac Task06\Q6.java
java -cp Task06 Q6
```

**Q7 – Bottleneck Redesign**

```bat
javac Task07\Q7.java
java -cp Task07 Q7
```

### GitHub Codespaces / Linux Terminal

Use forward slashes in the compilation commands:

```bash
javac Task01/Q1.java
java -cp Task01 Q1
```

The same pattern applies to the remaining six tasks.

To reproduce the benchmark measurements, execute Q1, Q2, Q4, Q6 and Q7 three times and retain each complete console output.

---

# 10. EVIDENCE AND DOCUMENTATION

The repository contains supporting evidence for implementation and experimental validation.

### Included materials

- Seven Java source files.
- Task-wise CMD execution screenshots.
- Raw console outputs.
- Three captured executions for each timed benchmark.
- Correctness-test outputs for Q3 and Q5.
- Performance comparison graphs.
- Task-wise evidence folders.

The screenshots document the actual compilation and execution of the Java programs.

The raw `.txt` files preserve the numerical results used for the experimental analysis.

---

# 11. GITHUB VERSION CONTROL

The repository is organised into separate task-wise commits to maintain a clear submission history.

### Recommended commit organisation

| Commit | Description |
|---|---|
| 1 | Add assignment README and supporting documentation |
| 2 | Task 1 – String performance analysis |
| 3 | Task 2 – ArrayList and LinkedList comparison |
| 4 | Task 3 – equals() and hashCode() validation |
| 5 | Task 4 – Map implementation comparison |
| 6 | Task 5 – Generic leaderboard implementation |
| 7 | Task 6 – Hospital triage system |
| 8 | Task 7 – Bottleneck diagnosis and redesign |

---

# 12. CONCLUSION

This assignment demonstrates the practical application of Java programming concepts through implementation, measurement, analysis and performance optimisation.

The experiments highlight the importance of selecting suitable data structures based on operational requirements, computational complexity, ordering guarantees and measured behaviour.

The final redesign in Q7 demonstrates the complete engineering process of identifying a bottleneck, selecting an alternative data structure, implementing the redesign and validating its performance through repeated executions.

Overall, the assignment connects Java programming fundamentals with experimental evaluation and evidence-based software engineering decisions.

---
