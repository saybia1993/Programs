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
		oneLineAction();             //karel�ڵ�һ���е���Ϊ�����������ڱ������һ�񣬷�������ڱ���������beepers
		secondAndThirdLineAction();  //karel�ڵڶ��������е���Ϊ���������Դӵ�һ������ȡbeepers
		                             //��������ڵڶ��������е����һ���ϣ��ȷŵڶ����е����һ��
		secondAction();              //�ѵڶ��������һ�������beepers�ӵڶ����е�һ��ʼ��ÿһ���һ��
		thirdAction();               //�ѵ����������һ�������beepers�ӵ������е�һ��ʼ��ÿһ���һ��
		testing();                   //�������к͵ڶ����Ƿ�beeper����һ�£����ڶ��ж�һ������Ӧλ����Ϊ���
	                                 //�Ǹ�beeper�����·���������beepers����һ�£���Ӧλ��Ϊ���һ��beeper
		                             //�����·����Լ��ұߵ�һ��
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
            else {                            //��Ӧif(beepersPresent())
                 move();
            }
       }
           pickBeeper();                      //���Ѽ����˵�һ�е�һ��ʱ����Ϊ���߿�ס�ˣ�ǰ���
           turnAround();                      //while (frontIsClear())���ܼ�����ȥ�����Ա����ٵ���д
           while (frontIsClear()) {           //һ��ѭ��
        	   move();
           }
           if (frontIsBlocked()){
        	   putBeeper();
           }
   }                                          //���ˣ�oneLineAction��������һ�����һ�񱻷����������
                                              //����������beepers

     private void secondAndThirdLineAction(){ //����ָ��ڶ���������beepers
    	   turnLeft();
    	   while (beepersPresent()){          //�ڶ��е����һ��
    	     pickBeeper();
    	     move();
    	     putBeeper();
    	     turnAround();
    	     move();
    	     turnAround();
    	     if (beepersPresent()){           //�����е����һ��ע��while��if��Ƕ��ʹ��
    	       pickBeeper();
    	       move();
    	       move();
    	       putBeeper();
    	       turnAround();
    	       move();
    	       move();
    	       turnAround();
             } 
    	   }                                  //���ˣ�secondAndThirdLineAction�������ڶ���������
       }                                      //�����һ���ϣ����ֱ�����ϵ�һ���е�beepers

     private void secondAction(){             //���еڶ���beepers
    	 move();                              //secondAndThirdLineAction������karel�泯����
    	 turnLeft();
    	 while(frontIsClear()){               //�ѵ�һ��beeper���������
    	 if (beepersPresent()){               //����ӵ�һ��beeper��ʼѭ�����Ҳ���ͨ�õ�ʹkarel���ص�����
    		 pickBeeper();
    	 }
    	 move();
    	 }
    	 if (frontIsBlocked()){               //���������
    		 putBeeper();                     //����beeper
    		 turnAround();
    		 while(frontIsClear()){           //������ʼλ��
    			 move();
    		 }
    		 if (frontIsBlocked()){
    			 turnAround();                //ת��
    		 }
    	 }
    	 while (beepersPresent()){            //�ڶ���beeper��ʼ���������ѭ��
    		 pickBeeper();
    		 move();
    		 while (noBeepersPresent()){      //ѭ����ʼ
    		 move();
    	   }
    		 if (beepersPresent()){           //�ӵڶ���beeper��ʼ�����ص��ж����ݸ�Ϊǰ���Ƿ���beeper����
    			 turnAround();
    			 move();
    			 putBeeper();
    			 while(frontIsClear()){
    				 move();
    			 }
    			 if (frontIsBlocked()){
    				 turnAround();            //���ˣ�karel�ѵڶ��е�����beeper��������
    			 }
    		  }
         }
     }
     
     private void thirdAction(){              //���е�����beepers��ԭ��ͬ�ڶ��У����ظ���
    	 turnRight();                         //ʹkarel�泯����
    	 move();
    	 turnLeft();
    	 while(frontIsClear()){               //�ѵ�һ��beeper���������
        	 if (beepersPresent()){           //����ӵ�һ��beeper��ʼѭ�����Ҳ���ͨ�õ�ʹkarel���ص�����
        		 pickBeeper();
        	 }
        	 move();
        	 }
        	 if (frontIsBlocked()){           //���������
        		 putBeeper();                 //����beeper
        		 turnAround();
        		 while(frontIsClear()){       //������ʼλ��
        			 move();
        		 }
        		 if (frontIsBlocked()){
        			 turnAround();            //ת��
        		 }
        	 }
        	 while (beepersPresent()){        //�ڶ���beeper��ʼ���������ѭ��
        		 pickBeeper();
        		 move();
        		 while (noBeepersPresent()){    //ѭ����ʼ
        		 move();
        	   }
        		 if (beepersPresent()){         //�ӵڶ���beeper��ʼ�����ص��ж����ݸ�Ϊǰ���Ƿ���beeper����
        			 turnAround();
        			 move();
        			 putBeeper();
        			 while(frontIsClear()){
        				 move();
        			 }
        			 if (frontIsBlocked()){
        				 turnAround();          //���ˣ�karel�ѵ����е�����beeper��������
        			 }
        		  }
             }
     }
     
     private void testing(){        //���ڶ��к͵����еĲ�ֵ��ע������1��������� 2���ڶ��бȵ����ж�һ��
    	 turnLeft();
    	 move();
    	 turnRight();
    	 while (noBeepersPresent()){
    		 move();
    	 }
    	 
    	 if (beepersPresent()){         //�Ӵ����ڶ������ұߵ�beeper��     
    		 turnRight();
    		 move();                    //������һ��
    	 }
    	 
          if (noBeepersPresent()){      //���������ұ����û��beeper����ʱ���Ϊ����  
    		 turnAround();
    		 move();
    		 pickBeeper();
    		 move();
    		 putBeeper();               //�е��Ѿ���ȷ������������һ��beeper
    		 turnAround();
    		 move();
    		 turnLeft();                //karel�ڵڶ������ұߣ��泯��
    		 while (frontIsClear()){    //��ʼ�ռ����µ�����beepers
    			 if (beepersPresent()){
    				 pickBeeper();
    			 }
    			 move();
    		     }
             if (frontIsBlocked()){
            	 pickBeeper();            //�ڶ��е������һ��beeper�������ѭ���޷������������Լ�һ��
                 turnRight();
                 move();
                 turnRight();             //��ʱ��karel�ڵ����еĵ�һ���泯����
                 }                           
             while (frontIsClear()){
                if (beepersPresent()){
                    pickBeeper();
                }
                 move();
             }
             if (frontIsBlocked()){        //��������е����ұ�
            	 turnRight();
            	 move();
            	 move();
            	 turnRight();              //��ʱkarel�ڵ�һ�����ұߣ��泯���
             }
             while (noBeepersPresent()){
            	 move();
             }
          }  		 
        	
          else if (beepersPresent()) {     //ż����ʱ�򣬶�Ӧ   if (noBeepersPresent()){
        	     turnAround();             //ע�ⲻ������if�������ã���Ϊif, else if��������Խ�����
        	     pickBeeper();
        	     move();
        	     pickBeeper();
        	     move();
        	     putBeeper();
        	     turnLeft();
        	     move();
        	     putBeeper();               //��ʱ���������ĵ��Ͼ���һ��beeper
                 turnAround();
                 move();
                 turnRight();
                 move();
                 turnLeft();                 //karel��ʱ�ڵڶ����м䣬�泯��
        		 while (frontIsClear()){     //��ʼ�ռ����µ�����beepers
        			 if (beepersPresent()){
        				 pickBeeper();
        			 }
        			 move();
        		 }
                 if (frontIsBlocked()){
                	 pickBeeper();            //�ڶ��е������һ��beeper�������ѭ���޷������������Լ�һ��
                     turnRight();
                     move();
                     turnRight();             //��ʱ��karel�ڵ����еĵ�һ���泯����
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
          }//����ֵ������          
}//����������

