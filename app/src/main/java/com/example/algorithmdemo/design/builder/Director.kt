package com.example.algorithmdemo.design.builder

/**
 * Created by LJH on 2019/12/2
 * Description:指挥类
 */
class Director(builder: Builder) {
    private var mBuilder: Builder = builder

    fun createComputer(cpu: String, mainBoard: String, ram: String): Computer {
        //规范建造流程
        mBuilder.buildCpu(cpu)
        mBuilder.buildMainBoard(mainBoard)
        mBuilder.buildRam(ram)
        return mBuilder.create()
    }
}