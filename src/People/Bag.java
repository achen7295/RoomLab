package People;

public class Bag {
    int food, Ammo, rope;

    public int getFood(){
        return food;
    }

    public int getAmmo(){
        return Ammo;
    }

    public int getRope(){
        return rope;
    }

    public void setFood(int food){
        this.food = food;
    }

    public void setAmmo(int rocks){
        this.Ammo = rocks;
    }

    public void setRope(int rope){
        this.rope = rope;
    }

    public int gainFood(int x){
        this.food = this.food + x;
        return this.food;
    }

    public int gainAmmo(int x){
        this.Ammo = this.Ammo + x;
        return this.Ammo;
    }

    public int gainRope(int x){
        this.rope = this.rope + x;
        return this.rope;
    }

    public Bag(int food, int Ammo, int rope){
        this.food = food;
        this.Ammo = Ammo;
        this.rope = rope;
    }
}
