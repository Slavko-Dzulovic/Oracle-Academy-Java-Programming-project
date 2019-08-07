package oracle.java.programming;

public enum ItemType
{
    Audio("AU"),
    Visual("VI"),
    AudioMobile("AM"),
    VisualMobile("VM");

    private String itemCode;

    ItemType(String itemCode)
    {
        this.itemCode=itemCode;
    }


}
