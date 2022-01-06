package ch3.ch15;

import java.util.ArrayList;

public class Shelf {

    protected ArrayList<String> shelf;

    public Shelf(){
        shelf = new ArrayList<String>();
    }
    public ArrayList<String> getShelf(){//어레이를 가져가는 get 메서드
        return shelf;
    }
    public int getCount(){//어레이의 사이즈를 알수있는데 get count 메서드
        return shelf.size();
    }

}
