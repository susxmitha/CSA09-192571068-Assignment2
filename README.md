# CSA09 – PROGRAMMING IN JAVA
## ASSIGNMENT 2 | CO2

### Java Collection Framework, Performance Analysis and Object-Oriented Programming

---

## 1. STUDENT AND COURSE DETAILS

| Particulars | Details |
|---|---|
| Course Name | Programming in Java |
| Course Code | CSA0901 |
| Assignment | Assignment 2 |
| Course Outcome | CO2 |
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

StringBuilder is recommended for repeated string construction in a thread-confined context. StringBuffer provides synchronized methods, while
