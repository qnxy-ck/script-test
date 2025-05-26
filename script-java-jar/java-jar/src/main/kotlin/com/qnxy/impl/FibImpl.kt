package com.qnxy.impl

import com.qnxy.FibInterface

/**
 * @author Qnxy
 */
class FibImpl : FibInterface {
    override fun fib(n: Int): Int {
        return fib(n, 0, 1)
    }

    private tailrec fun fib(n: Int, a: Int = 0, b: Int = 1): Int {
        return if (n == 0) a
        else fib(n - 1, b, a + b)
    }
}

