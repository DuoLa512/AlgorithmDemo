package com.example.algorithmdemo.design.builder

/**
 * Created by LJH on 2019/12/2
 * Description:Builder实现类
 */
class ComputerBuilder : Builder() {
    private val mComputer = Computer()
    override fun buildCpu(cpu: String) {
        mComputer.cpu = cpu
        println("组装CPU:$cpu")
    }

    override fun buildMainBoard(mainBoard: String) {
        mComputer.mainboard = mainBoard
        println("组装MainBoard:$mainBoard")
    }

    override fun buildRam(ram: String) {
        mComputer.ram = ram
        println("组装Ram:$ram")
    }

    override fun create(): Computer {
        println("组装完一台电脑")
        return mComputer
    }
}