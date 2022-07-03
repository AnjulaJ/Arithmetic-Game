package com.example.thegame

class Value(){

    fun setValue(termType:Int,term1:String,term2:String,term3:String,term4:String,op1:String,op2:String,op3:String):Float{
        var value="0.0".toFloat()

        var t1="0".toFloat()
        var t2="0".toFloat()
        var t3="0".toFloat()
        var t4="0".toFloat()
        var o1="0"
        var o2="0"
        var o3="0"

        if (termType==1){
             t1=term1.toFloat()
             value=t1
        }
        else if (termType==2) {
            t1 = term1.toFloat()
            t2 = term2.toFloat()

            o1=op1
        }
        else if (termType==3){
            t1=term1.toFloat()
            t2=term2.toFloat()
            t3=term3.toFloat()

            o1=op1
            o2=op2
        }

        else if (termType==4){
            t1=term1.toFloat()
            t2=term2.toFloat()
            t3=term3.toFloat()
            t4=term4.toFloat()

            o1=op1
            o2=op2
            o3=op3
        }


        if (termType!=1){
            when (o1) {
                "+" ->{
                    value=t1+t2
                    when (o2) {
                        "+" ->{
                            value=t1+t2+t3
                            when (o3) {
                                "+" ->{
                                    value=t1+t2+t3+t4
                                }
                                "-" ->{
                                    value=t1+t2+t3-t4
                                }
                                "*" ->{
                                    value=((t1+t2)+t3)*t4
                                }
                                "/" ->{
                                    value=((t1+t2)+t3)/t4
                                }
                            }
                        }
                        "-" ->{
                            value=t1+t2-t3
                            when (o3) {
                                "+" ->{
                                    value=t1+t2-t3+t4
                                }
                                "-" ->{
                                    value=t1+t2-t3-t4
                                }
                                "*" ->{
                                    value=((t1+t2)-t3)*t4
                                }
                                "/" ->{
                                    value=((t1+t2)-t3)/t4
                                }

                            }

                        }
                        "*" ->{
                            value=(t1+t2)*t3
                            when (o3) {
                                "+" ->{
                                    value=((t1+t2)*t3)+t4
                                }
                                "-" ->{
                                    value=((t1+t2)*t3)-t4
                                }
                                "*" ->{
                                    value=((t1+t2)*t3)*t4
                                }
                                "/" ->{
                                    value=((t1+t2)*t3)/t4
                                }

                            }
                        }
                        "/" ->{
                            value=(t1+t2)/t3
                            when (o3) {
                                "+" ->{
                                    value=((t1+t2)/t3)+t4
                                }
                                "-" ->{
                                    value=((t1+t2)/t3)-t4
                                }
                                "*" ->{
                                    value=((t1+t2)/t3)*t4
                                }
                                "/" ->{
                                    value=((t1+t2)/t3)/t4
                                }
                                "0" ->{
                                    value=(t1+t2)/t3
                                }
                            }
                        }
                    }

                }

                "-" ->{
                    value=t1-t2
                    when (o2) {
                        "+" ->{
                            value=(t1-t2)+t3
                            when (o3) {
                                "+" ->{
                                    value=t1-t2+t3+t4
                                }
                                "-" ->{
                                    value=t1-t2+t3-t4
                                }
                                "*" ->{
                                    value=((t1-t2)+t3)*t4
                                }
                                "/" ->{
                                    value=((t1-t2)+t3)/t4
                                }

                            }
                        }
                        "-" ->{
                            value=(t1-t2)-t3
                            when (o3) {
                                "+" ->{
                                    value=t1-t2-t3+t4
                                }
                                "-" ->{
                                    value=t1-t2-t3-t4
                                }
                                "*" ->{
                                    value=((t1-t2)-t3)*t4
                                }
                                "/" ->{
                                    value=((t1-t2)-t3)/t4
                                }
                            }

                        }
                        "*" ->{
                            value=(t1-t2)*t3
                            when (o3) {
                                "+" ->{
                                    value=((t1-t2)*t3)+t4
                                }
                                "-" ->{
                                    value=((t1-t2)*t3)-t4
                                }
                                "*" ->{
                                    value=((t1-t2)*t3)*t4
                                }
                                "/" ->{
                                    value=((t1-t2)*t3)/t4
                                }
                            }
                        }
                        "/" ->{
                            value=(t1-t2)/t3
                            when (o3) {
                                "+" ->{
                                    value=((t1-t2)/t3)+t4
                                }
                                "-" ->{
                                    value=((t1-t2)/t3)-t4
                                }
                                "*" ->{
                                    value=((t1-t2)/t3)*t4
                                }
                                "/" ->{
                                    value=((t1-t2)/t3)/t4
                                }
                            }
                        }

                    }
                }
                "*" ->{
                    value=t1*t2
                    when (o2) {
                        "+" ->{
                            value=(t1*t2)+t3
                            when (o3) {
                                "+" ->{
                                    value=(t1*t2)+t3+t4
                                }
                                "-" ->{
                                    value=((t1*t2)+t3)-t4
                                }
                                "*" ->{
                                    value=((t1*t2)+t3)*t4
                                }
                                "/" ->{
                                    value=((t1*t2)+t3)/t4
                                }

                            }
                        }
                        "-" ->{
                            value=(t1*t2)-t3
                            when (o3) {
                                "+" ->{
                                    value=(t1*t2)-t3+t4
                                }
                                "-" ->{
                                    value=(t1*t2)-t3-t4
                                }
                                "*" ->{
                                    value=((t1*t2)-t3)*t4
                                }
                                "/" ->{
                                    value=((t1*t2)-t3)/t4
                                }
                            }

                        }
                        "*" ->{
                            value=(t1*t2)*t3
                            when (o3) {
                                "+" ->{
                                    value=((t1*t2)*t3)+t4
                                }
                                "-" ->{
                                    value=((t1*t2)*t3)-t4
                                }
                                "*" ->{
                                    value=((t1*t2)*t3)*t4
                                }
                                "/" ->{
                                    value=((t1*t2)*t3)/t4
                                }
                            }
                        }
                        "/" ->{
                            value=(t1*t2)/t3
                            when (o3) {
                                "+" ->{
                                    value=((t1*t2)/t3)+t4
                                }
                                "-" ->{
                                    value=((t1*t2)/t3)-t4
                                }
                                "*" ->{
                                    value=((t1*t2)/t3)*t4
                                }
                                "/" ->{
                                    value=((t1*t2)/t3)/t4
                                }
                            }
                        }
                    }
                }

                "/" ->{
                    value=t1/t2
                    when (o2) {
                        "+" ->{
                            value=(t1/t2)+t3
                            when (o3) {
                                "+" ->{
                                    value=(t1/t2)+t3+t4
                                }
                                "-" ->{
                                    value=(t1/t2)+t3-t4
                                }
                                "*" ->{
                                    value=((t1/t2)+t3)*t4
                                }
                                "/" ->{
                                    value=((t1/t2)+t3)/t4
                                }
                            }
                        }
                        "-" ->{
                            value=(t1/t2)-t3
                            when (o3) {
                                "+" ->{
                                    value=(t1/t2)-t3+t4
                                }
                                "-" ->{
                                    value=(t1/t2)-t3-t4
                                }
                                "*" ->{
                                    value=((t1/t2)-t3)*t4
                                }
                                "/" ->{
                                    value=((t1/t2)-t3)/t4
                                }
                            }

                        }
                        "*" ->{
                            value=(t1/t2)*t3
                            when (o3) {
                                "+" ->{
                                    value=((t1/t2)*t3)+t4
                                }
                                "-" ->{
                                    value=((t1/t2)*t3)-t4
                                }
                                "*" ->{
                                    value=((t1/t2)*t3)*t4
                                }
                                "/" ->{
                                    value=((t1/t2)*t3)/t4
                                }
                            }
                        }
                        "/" ->{
                            value=(t1/t2)/t3
                            when (o3) {
                                "+" ->{
                                    value=((t1/t2)/t3)+t4
                                }
                                "-" ->{
                                    value=((t1/t2)/t3)-t4
                                }
                                "*" ->{
                                    value=((t1/t2)/t3)*t4
                                }
                                "/" ->{
                                    value=((t1/t2)/t3)/t4
                                }
                            }
                        }
                    }
                }
            }
        }

        return value

    }
}