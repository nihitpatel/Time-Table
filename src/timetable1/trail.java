package timetable1;
//Take 4 dimentional teacher array if you want to have multiple teachers for same subject. teacher[a][b][c][d]
//[a] = total number of subjects
//[b] = total number of teachers for a subject 'a'
//[c][d] = c--day and d--lecture Number (free/busy)(1/0)

//this code will generate only single periods of every subject. For double period some modification has to be made
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class trail {
    
  static int teachermain[][][] = {{{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},
            {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},
            {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},
            {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},
            {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},
            {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}}};
  

    public static void main(String st[]) throws IOException
    {
         
        
        System.out.println("Time Table for CSE 1 ");
        trail t1 = new trail();
        t1.generate();
        
//        
        System.out.println("Time Table for CSE 2 ");
        trail t2 = new trail();
  //      t2.teacherdata();
//        
  //      t2.generate();
    }

    
    public void generate() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter when you want lab to be (1-5) : ");
        int labl = sc.nextInt();
        labl--;
        
        int teacher[][][] = new int[6][6][6];
        teacher = initialize();
        int repeat=0;
       do{
           repeat = 0;
        int timetable[][] = new int[6][6];
   //     int labover[] = {0,0,0,0,0,0};
        
             // int subcredit[] = new int[6]; // 1.java 2.Mi 3.AAD 4.SP 5.CS 6.DE
        double subcredit[] = {5,5,5,5,2,2};
  //      int lab[] = new int[6];
       
        //int sublecperday[] = new int[6];
        double sublecperday[][] = {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
        //int teacher[][][] = new int[6][6][6];
       
    //    int week[][] = new int[4][6];
        int i,j,counter=0; // counter for indexing temp;
       // int temp[] = new int[6];  // for not checking the same number/subject(randomsub) second time;
       int temp[] = {-1,-1,-1,-1,-1,-1}; 
       int randomsub,flag=0;
       int lab=0;
          Random rand = new Random();
          int signal = 0;
        //  int batchlan[][] = new int[4][6];
         int batchlab[][] = {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
        for(i=0;i<6;i++)
        {
            repeat = 0;
            signal=0;
            lab=0;
            System.out.println("\nFor Day " + (i+1) + "\n===========");
            
         //   ------------------------------------------------------------------
         

        //   ------------------------------------------------------------------
            
            for(j=0;j<6;j++)
            {
                
                flag=0;
                
                 for(counter=0;counter<6;counter++)
                 {
                     temp[counter]=-1;
                 }
                counter=0;
        //      System.out.print("Lecture " + (j+1));
                while(flag!=1 && counter<6 )   //check for only 6 times with all subjects then display not possible
                {
                     randomsub = (rand.nextInt(Integer.MAX_VALUE)%6);
                    // System.out.println(" Random No. : " + randomsub);
                      if(signal==0 )
                     {
                         int no=0;int q=0;
                         int tem[] = {-1,-1,-1,-1,-1,-1};
                         while(no<6 && q<4)
                         //for(int q=0;q<4;q++)
                         {
                             
                             if(randomsub!=tem[0] && randomsub!=tem[1] && randomsub!=tem[2] && randomsub!=tem[3] && randomsub!=tem[4] &&
                                     randomsub!=tem[5] && batchlab[q][randomsub]==1 && teacher[randomsub][j][i]==1 && teacher[randomsub][j+1][i]==1)
                             {
                                 j=labl;
                                 temp[no]=randomsub;
                                 no++;
                                 System.out.println("For Batch : " + (q+1));
                                 batchlab[q][randomsub]=0;
                                 teacher[randomsub][j][i]=0;
                                 teacher[randomsub][j+1][i]=0;
                                   System.out.println("Lecture " + (labl+1) + ": Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                             //   timetable[j][i]=randomsub+1;
                                   
                                System.out.println("Lecture " + (labl+2) + " : Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                              //  timetable[j+1][i]=randomsub+1;
                              q++;
                             }
                                                                                 
                             randomsub = (rand.nextInt(Integer.MAX_VALUE)%6);
                         }
                         
                        // j++;
                        flag=1;
                        j=-1;
                         signal = 1;
                         System.out.println();
                        
                     }
                      
                      else if(j==labl || j==labl+1)
                      {
                          flag=1;
                          break;
                      }
                      else if( signal==1 && randomsub!=temp[0] && randomsub!=temp[1]
                        && randomsub!=temp[2] && randomsub!=temp[3] && randomsub!=temp[4] && randomsub!=temp[5] && j!=labl && j!=labl+1)
                     {
                        
                       temp[counter]=randomsub;
                     counter++;
                     
                    
                     
                     if(sublecperday[i][randomsub]>0 && subcredit[randomsub]>0 )
                        {
                            
                         /*   if(j==labl && teacher[randomsub][j][i]==1 && teacher[randomsub][j+1][i]==1 && lab==0 && subcredit[randomsub]>=2 && sublecperday[i][randomsub]==2 && labover[randomsub]==0)
                            {
                                
                                System.out.println("==========================================");
                                labover[randomsub]=1;
                                System.out.println("Lecture " + (j+1) + ": Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                                timetable[j][i]=randomsub+1;
                                teacher[randomsub][j][i]=0;
                                   
                                System.out.println("Lecture " + (j+2) + " : Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                                timetable[j+1][i]=randomsub+1;
                                teacher[randomsub][j+1][i]=0;
                                sublecperday[i][randomsub]-=2;
                                subcredit[randomsub]-=2;
                                flag=1;
                                lab=1;
                                j++;
                                System.out.println("==========================================");
    //                             break;
                               
                            } */  
                         // else
                            if(teacher[randomsub][j][i]==1  && sublecperday[i][randomsub]>0)
                            {
                                System.out.println("--Lecture " + (j+1) + " : Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                               timetable[j][i]=randomsub+1;
                                teacher[randomsub][j][i]=0;
                                sublecperday[i][randomsub]--;
                                subcredit[randomsub]--;
                                flag=1;
    //                             break;
                            }   
                   /*          else if(sublecperday[i][randomsub]==2 && teacher[randomsub][j+1][i]==1 && teacher[randomsub][j][i]==1)
                                {
                                    j++;
                                     System.out.println(" : Teacher/Subject code : " + (randomsub+1) + " Subject Name : " + subname(randomsub));
                                     System.out.print("Lecture " + (j+1));
                                     System.out.println("L : Teacher/Subject code : " + (randomsub+2) + " Subject Name : " + subname(randomsub));
                                   teacher[randomsub][j][i]=0;
                                    sublecperday[i][randomsub]=-1;
                                    subcredit[randomsub]-=2;
                                    flag=1;
                                     break;
                                    
                                }
                            */   
                               
                            
                        }
                    }
                }
                    if(flag==0)
                {
                   // System.out.println(" Not possible");
                    int k;
                    for( k=5;k>=0;k--)
                    {
                        if(subcredit[k]>0 && teacher[k][j][i]==1 && timetable[j-1][i]!=k+1)// && sublecperday[i][k]>0)
                        {   
                             System.out.println("Lecture " + (j+1) + " : Teacher/Subject code : " + (k+1) + " Subject Name : " + subname(k) + "----");
                             timetable[j][i]=k+1;
                             teacher[k][j][i]=0;
                              // sublecperday[i][k]--;
                                subcredit[k]--;
                                flag=1;
                               // j++;
//                                if(j==6)
//                                {
//                                    break;
//                                }
                        }
                        else{
                         //   System.out.println("NP");
                        }
                       
                    }
                }
                    
                   if(flag==0)
                   {
                       System.out.println("Lecture " + (j+1) + " : Sports/Lib  ---- Because not possible");
                       timetable[j][i]=0;
                   }
            }
            
        
        }
         
        
     //   System.out.println("\nSubject Left "); //Subject are left due to counter value reaches to 10
     System.out.println();
     for(i=0;i<6;i++)
        {
            System.out.println("For Subject " + (i+1) + " : "+ subcredit[i] + " " + subname(i));
            if(subcredit[i]!=0)
            {
            //    repeat = 1;
              //  teacher = initialize();
//                Runtime.getRuntime().exec("cls");
             //   break;
            }
        }
     
     } while(repeat==1);
         save(teacher);
        
    //   while(true);
      System.out.println("\nTeachers Array : ");
        for(int p=0;p<6;p++)
        {
            System.out.println("\nFor " + subname(p));
                    {
                        for(int q=0;q<6;q++)
                        {
                            for(int r=0;r<6;r++)
                            {
                                System.out.print(teacher[p][r][q] + " ");
                            }
                            System.out.println();
                        }
                    }
        }
    }
    
    private static String subname(int i) {
        if(i==0)
        {
            return "Java";
        }
        else if(i==1)
        {
            return "MI";
        }
        else if(i==2)
        {
            return "AAD";
        }
        else if(i==3)
        {
            return "SP";
        }
        else if(i==4)
        {
            return "CS";
        }
        else
        {
            return "DE";
        }
        
    }
    
    public void teacherdata()
    {
        for(int i=0;i<6;i++)
        {
            System.out.println("Subject " + subname(i));
            for(int j=0;j<6;j++)
            {
                for(int k=0;k<6;k++)
                {
                    System.out.print(teachermain[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }
    
    int [][][] initialize()
    {
        int teacher[][][] = new int[6][6][6];
        for(int i=0;i<teachermain.length;i++)
        {
            for(int j=0;j<teachermain[0].length;j++)
            {
                for(int k=0;k<teachermain[0][0].length;k++)
                {
                    teacher[i][j][k]=teachermain[i][j][k];
                }
            }
        }
        return teacher;
    }

    private void save(int[][][] teacher) {
 
     for(int i=0;i<teachermain.length;i++)
        {
            for(int j=0;j<teachermain[0].length;j++)
            {
                for(int k=0;k<teachermain[0][0].length;k++)
                {
                    teachermain[i][j][k]=teacher[i][j][k];
                }
            }
        }
    }
    
}
