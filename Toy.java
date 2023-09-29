package FinalTest_Task2;

import javax.print.attribute.standard.MediaSize.NA;

public class Toy {
    private int ID;

    private String Name;

    private int Quantity;

    private int Rarity;

    public Toy(int ID, String Name, int Quantity, int Rarity){
        this.ID = ID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Rarity = Rarity;
    }

    public void Constructor(){
        Toy toy = new Toy(ID, Name, Quantity, Rarity);
    }

    public int GetID(){
        return ID;
    }

    public void SetID(int ID){
        this.ID = ID;
    }

    public String GetName(){
        return Name;
    }

    public void SetName(String Name){
        this.Name = Name;
    }

    public int GetQuantity(){
        return Quantity;
    }

    public void SetQuantity(int Quantity){
        this.Quantity = Quantity;
    }

    public int GetRarity(){
        return Rarity;
    }

    public void Setrarity(int Rarity){
        this.Rarity = Rarity;
    }

    public String toString(){
        return "ID: "+GetID()+"; Name: "+GetName()+"; Quantity: "+GetQuantity()+"; Rarity: "+GetRarity();
    }
}
