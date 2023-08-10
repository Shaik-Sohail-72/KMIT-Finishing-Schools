public int find(int arr[][],boolean vis[][],int i,int j,int c){
        int c=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int i=curr.i;
            int j=curr.j;
            if(isval(arr,i-2,j+1) && arr[i-2][j+1]==1){
                q.add(new Pair(i-2,j+1,cn+1));
                c+=1;
            }
            if(isval(arr,i-2,j+1) && arr[i-2][j+1]==1){
                q.add(new Pair(i-2,j+1,cn+1));
                c+=1;
            }
            if(isval(arr,i-2,j+1) && arr[i-2][j+1]==1){
                q.add(new Pair(i-2,j+1,cn+1));
                c+=1;
            }
            if(isval(arr,i-2,j+1) && arr[i-2][j+1]==1){
                q.add(new Pair(i-2,j+1,cn+1));
                c+=1;
            }
                if(is(N,)){
                    q.add(new Pair(i-1,j+2,cn+1));
                }
                if(is(N,i+1,j+2)){
                    q.add(new Pair(i+1,j+2,cn+1));
                }
                if(is(N,i+2,j+1)){
                    q.add(new Pair(i+2,j+1,cn+1));
                }
                if(is(N,i+2,j-1)){
                    q.add(new Pair(i+2,j-1,cn+1));
                }
                if(is(N,i+1,j-2)){
                    q.add(new Pair(i+1,j-2,cn+1));
                }
                if(is(N,i-1,j-2)){
                    q.add(new Pair(i-1,j-2,cn+1));
                }
                if(is(N,i-2,j-1)){
                    q.add(new Pair(i-2,j-1,cn+1));
                }
            }
        }
        return -1;