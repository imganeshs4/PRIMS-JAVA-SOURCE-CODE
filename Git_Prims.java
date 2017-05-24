import java.util.*;
import java.io.*;
import java.lang.*;

public class Prims
{
 public static int G[][];
 public static int n;
 

 public static void prim(int G[][], int n)
 {
    int startnode=0;
    int cost[][]= new int[10][10];
    int distance[]= new int[10];
    int path[]= new int[10];
    int visited[]= new int[10];
    int mst[][]= new int[10][10];
    int count, mindistance, nextnode=-1, i,j;
    int sum=0,k=0;
    
    for(i=0;i < n;i++)
    {
      for(j=0;j < n;j++)
      {
        if(G[i][j]==0)
         cost[i][j]=999;
        else
         cost[i][j]=G[i][j];
      }
    }

    for(i=0;i< n;i++)
    {
      distance[i]=cost[startnode][i];
      path[i]=startnode;
      visited[i]=0;
    }
 
    distance[startnode]=0;
    visited[startnode]=1;
    count=1;
  
    while(count < n)
    {
      mindistance=999;
      for(i=0;i < n;i++)
      {
        if(distance[i] < mindistance && visited[i]==0)
        {
         mindistance=distance[i];
         nextnode=i;
        }
      }

     visited[nextnode]=1;
     
     mst[k][0]=nextnode;
     mst[k][1]=path[nextnode];
     k++;
     
     sum=sum+cost[nextnode][path[nextnode]];
     

     for(i=0;i < n;i++)
     {
       if(visited[i]==0 && cost[nextnode][i] < distance[i])
       {
        distance[i]=cost[nextnode][i];
        path[i]=nextnode;
       }
     }
     count++;
    }

    if(sum>=999)
     System.out.println("\nSpanning tree doesnt exit");
    else
     { 
       System.out.println("\nThe edges selected for MST are:");
       for(i=0;i<n-1;i++)
         System.out.printf("\nEdge%d :  %d----%d   cost = %d",(i+1),mst[i][0],mst[i][1],cost[mst[i][0]][mst[i][1]]);
       System.out.println("\nMin cost of Spanning tree:"+sum);
     }
     
    
 }


 public static void main(String args[])
 {
    G=new int[10][10];
    int i, j, n, u;

    Scanner in=new Scanner(System.in);

    System.out.print("\nEnter the no. of vertices: ");
    n=in.nextInt();
   
    System.out.print("\nEnter the adjacency matrix:\n");
    for(i=0;i < n;i++)
    {
     for(j=0;j < n;j++)
     {
      G[i][j]=in.nextInt();
     }
    }

    prim(G,n);
 }
 
}   
