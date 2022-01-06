package ch3.naver;

public class Notebook extends Appliance{
    protected String mouse;
    protected String keybord;
    protected String inter;

    public Notebook(){
        mouse = "트랙패드가 있습니다.";
        inter = "인터넷이 됩니다.";
        keybord = "키보드가 있습니다.";
    }
    public String NotebookInFo(){
        return "노트북의 특징은"+eng+iot+mouse+inter+keybord+"입니다.";
    }
}
