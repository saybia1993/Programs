/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

/*
 * Name:    songy6@uci.edu
 * Section Leader:  ICS department
 */

public class MidpointFindingKarel extends SuperKarel  {

	public void run() {
		oneLineAction();             //karel在第一横行的行为，期望可以在本行最后一格，放上相等于本行列数的beepers
		secondAndThirdLineAction();  //karel在第二，三横行的行为，期望可以从第一横行中取beepers
		                             //并交替放在第二，三横行的最后一格上，先放第二横行的最后一格
		secondAction();              //把第二横行最后一格的所有beepers从第二横行第一格开始，每一格放一个
		thirdAction();               //把第三横行最后一格的所有beepers从第三横行第一格开始，每一格放一个
		testing();                   //检测第三行和第二行是否beeper数量一致，若第二行多一个，对应位置则为多出
	                                 //那个beeper的正下方，若两行beepers数量一致，对应位置为最后一个beeper
		                             //的正下方，以及右边的一个
	}                          
       
	private void oneLineAction()  {
    	   while (frontIsClear()) {
    	   putBeeper();
    	   move();
    	     }
           putBeeper();
           turnAround();
           move();
           while (frontIsClear()){
            if (beepersPresent()){
            	pickBeeper();
            	turnAround();
            	while (frontIsClear()){
            	 move();
            	}
            	if (frontIsBlocked()){
            		putBeeper();
            		turnAround();
            		move();
                 }
            }
            else {                            //对应if(beepersPresent())
                 move();
            }
       }
           pickBeeper();                      //当搜集到了第一行第一个时，因为被边框档住了，前面的
           turnAround();                      //while (frontIsClear())不能继续下去，所以必须再单独写
           while (frontIsClear()) {           //一次循环
        	   move();
           }
           if (frontIsBlocked()){
        	   putBeeper();
           }
   }                                          //至此，oneLineAction结束。第一行最后一格被放上了相等于
                                              //本行列数的beepers

     private void secondAndThirdLineAction(){ //交替分给第二，第三行beepers
    	   turnLeft();
    	   while (beepersPresent()){          //第二行的最后一格
    	     pickBeeper();
    	     move();
    	     putBeeper();
    	     turnAround();
    	     move();
    	     turnAround();
    	     if (beepersPresent()){           //第三行的最后一格，注意while和if的嵌套使用
    	       pickBeeper();
    	       move();
    	       move();
    	       putBeeper();
    	       turnAround();
    	       move();
    	       move();
    	       turnAround();
             } 
    	   }                                  //至此，secondAndThirdLineAction结束。第二，三横行
       }                                      //的最后一格上，被分别交替放上第一行中的beepers

     private void secondAction(){             //排列第二行beepers
    	 move();                              //secondAndThirdLineAction结束，karel面朝北方
    	 turnLeft();
    	 while(frontIsClear()){               //把第一个beeper带至最左边
    	 if (beepersPresent()){               //如果从第一个beeper开始循环，找不到通用的使karel返回的条件
    		 pickBeeper();
    	 }
    	 move();
    	 }
    	 if (frontIsBlocked()){               //行至最左边
    		 putBeeper();                     //放下beeper
    		 turnAround();
    		 while(frontIsClear()){           //返回起始位置
    			 move();
    		 }
    		 if (frontIsBlocked()){
    			 turnAround();                //转身
    		 }
    	 }
    	 while (beepersPresent()){            //第二个beeper开始，程序可以循环
    		 pickBeeper();
    		 move();
    		 while (noBeepersPresent()){      //循环开始
    		 move();
    	   }
    		 if (beepersPresent()){           //从第二个beeper开始，返回的判断依据改为前方是否有beeper存在
    			 turnAround();
    			 move();
    			 putBeeper();
    			 while(frontIsClear()){
    				 move();
    			 }
    			 if (frontIsBlocked()){
    				 turnAround();            //至此，karel把第二行的所有beeper排列起来
    			 }
    		  }
         }
     }
     
     private void thirdAction(){              //排列第三行beepers，原理同第二行，不重复了
    	 turnRight();                         //使karel面朝北面
    	 move();
    	 turnLeft();
    	 while(frontIsClear()){               //把第一个beeper带至最左边
        	 if (beepersPresent()){           //如果从第一个beeper开始循环，找不到通用的使karel返回的条件
        		 pickBeeper();
        	 }
        	 move();
        	 }
        	 if (frontIsBlocked()){           //行至最左边
        		 putBeeper();                 //放下beeper
        		 turnAround();
        		 while(frontIsClear()){       //返回起始位置
        			 move();
        		 }
        		 if (frontIsBlocked()){
        			 turnAround();            //转身
        		 }
        	 }
        	 while (beepersPresent()){        //第二个beeper开始，程序可以循环
        		 pickBeeper();
        		 move();
        		 while (noBeepersPresent()){    //循环开始
        		 move();
        	   }
        		 if (beepersPresent()){         //从第二个beeper开始，返回的判断依据改为前方是否有beeper存在
        			 turnAround();
        			 move();
        			 putBeeper();
        			 while(frontIsClear()){
        				 move();
        			 }
        			 if (frontIsBlocked()){
        				 turnAround();          //至此，karel把第三行的所有beeper排列起来
        			 }
        		  }
             }
     }
     
     private void testing(){        //检测第二行和第三行的差值，注意结果：1）两行相等 2）第二行比第三行多一个
    	 turnLeft();
    	 move();
    	 turnRight();
    	 while (noBeepersPresent()){
    		 move();
    	 }
    	 
    	 if (beepersPresent()){         //接触到第二行最右边的beeper了     
    		 turnRight();
    		 move();                    //向上跑一格
    	 }
    	 
          if (noBeepersPresent()){      //第三行最右边如果没有beeper，此时宽度为奇数  
    		 turnAround();
    		 move();
    		 pickBeeper();
    		 move();
    		 putBeeper();               //中点已经被确定，并放置了一个beeper
    		 turnAround();
    		 move();
    		 turnLeft();                //karel在第二行最右边，面朝西
    		 while (frontIsClear()){    //开始收集余下的无用beepers
    			 if (beepersPresent()){
    				 pickBeeper();
    			 }
    			 move();
    		     }
             if (frontIsBlocked()){
            	 pickBeeper();            //第二行的左起第一个beeper，上面的循环无法捡起来，所以加一个
                 turnRight();
                 move();
                 turnRight();             //此时，karel在第三行的第一格，面朝东面
                 }                           
             while (frontIsClear()){
                if (beepersPresent()){
                    pickBeeper();
                }
                 move();
             }
             if (frontIsBlocked()){        //到达第三行的最右边
            	 turnRight();
            	 move();
            	 move();
            	 turnRight();              //此时karel在第一行最右边，面朝左边
             }
             while (noBeepersPresent()){
            	 move();
             }
          }  		 
        	
          else if (beepersPresent()) {     //偶数的时候，对应   if (noBeepersPresent()){
        	     turnAround();             //注意不能两个if并列连用，因为if, else if后面均可以接条件
        	     pickBeeper();
        	     move();
        	     pickBeeper();
        	     move();
        	     putBeeper();
        	     turnLeft();
        	     move();
        	     putBeeper();               //此时，两个中心点上均有一个beeper
                 turnAround();
                 move();
                 turnRight();
                 move();
                 turnLeft();                 //karel此时在第二行中间，面朝西
        		 while (frontIsClear()){     //开始收集余下的无用beepers
        			 if (beepersPresent()){
        				 pickBeeper();
        			 }
        			 move();
        		 }
                 if (frontIsBlocked()){
                	 pickBeeper();            //第二行的左起第一个beeper，上面的循环无法捡起来，所以加一个
                     turnRight();
                     move();
                     turnRight();             //此时，karel在第三行的第一格，面朝西面
                 }                           
                 while (frontIsClear()){
                    if (beepersPresent()){
                        pickBeeper();
                    }
                     move();
                 }
                 if (frontIsBlocked()){
                	 turnRight();
                	 move();
                	 move();
                	 turnRight();
                 }
                 while (noBeepersPresent()){
                	 move();
                 }
    		 }                 
          }//检测差值总括号          
}//程序总括号

