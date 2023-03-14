package com.example.sweefttask

fun main() {

    //check algorithm #1
    val numbers = listOf(1, 1, 2, 3, 3)
    val nonRepeatedNumber = findTheUniqueNumberInArray(numbers)
    println("Algorithm 1 - The non-repeated number is $nonRepeatedNumber")


    //check algorithm #2
    val inputNumber = minimumCoins(6)
    println("Algorithm 2 - number of coins needed to make a change for this coin is $inputNumber")

    //check algorithm #3
    val intArray = listOf(1, 2, 3, 4, 5, 6)
    val smallestNumber = smallestMissingPositiveInteger(intArray)
    println("Algorithm 3 - smallest number outside of the array is $smallestNumber")


    //check algorithm #4
    val binaryStringSum = binaryStringSum("1010", "1011")
    println("Algorithm 4 - The sum of strings is $binaryStringSum")


    //check algorithm #5
    val climbingVariants = climbTheStairs(12)
    println("Algorithm 5 - There are  $climbingVariants ways to climb the stairs")


    //check the assignment #6
    val list = LinkedList()
    list.add(0)
    list.add(1)
    list.add(2)
    list.add(3)
    list.delete(2)
    list.printList()

}

//AlgorithmNumberOne
private fun findTheUniqueNumberInArray(numbers: List<Int>): Int {
    for (i in numbers.indices) {
        var repeatedNumber = false
        for (j in numbers.indices) {
            if (i != j && numbers[i] == numbers[j]) {
                repeatedNumber = true
                break
            }
        }
        if (!repeatedNumber) {
            return numbers[i]
        }
    }
    throw IllegalArgumentException("No non-repeated number have been found in the list")
}


//AlgorithmNumberTwo
fun minimumCoins(amount: Int): Int {
    val coins = intArrayOf(1,5,10,20,50)
    var remaining = amount
    var coinCount = 0
    for (coin in coins) {
        coinCount += remaining / coin
        remaining %= coin
        if (remaining == 0) {
            break
        }
    }
    return coinCount
}

//AlgorithmNumberThree
fun smallestMissingPositiveInteger(input: List<Int>): Int {
    var result = 0
    input.filter { it > 0 }.distinct().sorted().reduceIndexed { i, acc, data ->
        if (i != acc && result == 0) {
            result = i
        }
        data
    }.also {
        if (result == 0) {
            result = it + 1
        }
    }
    return result
}

//AlgorithmNumberFour
fun binaryStringSum(stringOne: String, StringTwo: String): String {
    val number0 = stringOne.toInt(2)
    val number1 = StringTwo.toInt(2)
    val sum = number0 + number1
    return Integer.toBinaryString(sum)
}

//AlgorithmNumberFive
fun climbTheStairs(n: Int): Int {
    if (n <= 3) {
        return n
    }
    var a = 3
    var b = 2
    for (i in 0 until n - 3) {
        a = a + b
        b = a - b
    }
    return a
}