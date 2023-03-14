package com.example.sweefttask

class Node(var data: Int, var next: Node? = null)

class LinkedList {
    private var head: Node? = null

    fun delete(value: Int) {
        if (head == null) return

        if (head!!.data == value) {
            head = head!!.next
            return
        }

        var curr = head
        var prev: Node? = null

        while (curr != null && curr.data != value) {
            prev = curr
            curr = curr.next
        }

        if (curr == null) return

        prev!!.next = curr.next
    }

    fun add(value: Int) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            return
        }
        var curr = head
        while (curr!!.next != null) {
            curr = curr.next
        }
        curr.next = newNode
    }

    fun printList() {
        var curr = head
        while (curr != null) {
            print("${curr.data} -> ")
            curr = curr.next
        }
        println("null")
    }
}