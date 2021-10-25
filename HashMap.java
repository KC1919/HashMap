import java.util.ArrayList;
import java.util.LinkedList;

class HashMap
{
    private class Node 
    {
        int key;
        int value;
        Node next = null;
    
        Node(int key, int value) 
        {
            this.key = key;
            this.value=value;
        }
    }

    private class linkedList 
    {
        private Node head=null, tail=null;
        public int size=0;

        public void addLast(int key,int value)
        {
            Node n=new Node(key,value);
            if(head==null)
            {
                head=n;
                tail=n;
            }
            else
            {
                tail.next=n;
                tail=tail.next;
            }
            size++;
        }

        public void removeFirst()
        {
            if(head==null)
            return;

            else
            {
                Node temp=head;
                head=head.next;
                temp.next=null;
                size--;
            }
        }

        private int size()
        {
            return this.size;
        }
    }
    

    private int hmSize;
    private linkedList containers[];

    HashMap()
    {
        this.hmSize=10;
        this.containers=new linkedList[10];
        for(int i=0;i<10;i++)
        {
            this.containers[i]=new linkedList();
        }
    }
    HashMap(int size)
    {
        this.containers=new linkedList[size];
        this.hmSize=size;
        for(int i=0;i<size;i++)
        {
            this.containers[i]=new linkedList();
        }
    }

    public ArrayList<Integer> keySet()
    {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<this.hmSize;i++)
        {
            linkedList group=containers[i];
            Node n=group.head;
            while(n!=null)
            {
                Node rem=removeFirst(n);
                list.add(rem.key);
                addFirst(rem);
            }
        }
        return list;
    }

    public void remove(Integer key)
    {
        boolean isKey=containsKey(key);
        linkedList group=getGroupList(key);
        Node n=group.head;

        while(n!=null)
        {
            if(n.key==key)
            {
                
            }
        }

    }

    public boolean containsKey(Integer key)
    {
        int hashCode=hashCode(key);
        linkedList group=containers[hashCode];
        Node n=group.head;
        while(n!=null)
        {
            if(n.key==key)
            return true;

            n=n.next;
        }
        return false;
    }

    public linkedList getGroupList(Integer key)
    {
        int hashCode=hashCode(key);
        linkedList group=containers[hashCode];
        return group;
    }

    private int hashCode(Integer key)
    {
        int hashCode=key.hashCode();
        return hashCode % this.hmSize;
    }
}
