package com.example.algorithmdemo.design.builder

/**
 * Created by LJH on 2019/12/2
 * Description:抽象Builder类
 */
abstract class Builder {
    abstract fun buildCpu(cpu: String)
    abstract fun buildMainBoard(mainBoard: String)
    abstract fun buildRam(ram: String)
    abstract fun create(): Computer
}