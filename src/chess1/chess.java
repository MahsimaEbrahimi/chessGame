/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess1;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author mahsima
 */
public class chess {

    Scanner input = new Scanner(System.in);
    Mohre[] mohre = new Mohre[16];
    Mohre[] mohre_b = new Mohre[16];
    home[][] khaneh = new home[8][8];

    public void const_white() {
        for (int i = 0; i < 8; i++) {
            sarbaz sarbaz__ = new sarbaz(i, 1, i, "white", "num1");
            mohre[i] = sarbaz__;
        }
        rokh rohk1__ = new rokh(0, 0, 8, "white", "num1");
        rokh rohk2__ = new rokh(7, 0, 9, "white", "num1");
        mohre[8] = rohk1__;
        mohre[9] = rohk2__;
        king king__ = new king(4, 0, 10, "white", "num1");
        mohre[10] = king__;
        vazir vazir__ = new vazir(3, 0, 11, "white", "num1");
        mohre[11] = vazir__;
        fil fil1__ = new fil(2, 0, 12, "white", "num1");
        mohre[12] = fil1__;
        fil fil2__ = new fil(5, 0, 13, "white", "num1");
        mohre[13] = fil2__;
        horse horse1__ = new horse(1, 0, 14, "white", "num1");
        mohre[14] = horse1__;
        horse horse2__ = new horse(6, 0, 15, "white", "num1");
        mohre[15] = horse2__;
    }

    public void const_black() {
        for (int i = 0; i < 8; i++) {
            sarbaz sarbaz_b_ = new sarbaz(i, 1, i, "black", "num1");
            mohre_b[i] = sarbaz_b_;
        }
        rokh rohk1_b_ = new rokh(0, 0, 8, "black", "num2");
        rokh rohk2_b_ = new rokh(7, 0, 9, "black", "num2");
        mohre_b[8] = rohk1_b_;
        mohre_b[9] = rohk2_b_;
        king king_b_ = new king(4, 0, 10, "black", "num2");
        mohre_b[10] = king_b_;
        vazir vazir_b_ = new vazir(3, 0, 11, "black", "num2");
        mohre_b[11] = vazir_b_;
        fil fil1_b_ = new fil(2, 0, 12, "black", "num2");
        mohre_b[12] = fil1_b_;
        fil fil2_b_ = new fil(5, 0, 13, "black", "num2");
        mohre_b[13] = fil2_b_;
        horse horse1_b_ = new horse(1, 0, 14, "black", "num2");
        mohre_b[14] = horse1_b_;
        horse horse2_b_ = new horse(6, 0, 15, "black", "num2");
        mohre_b[15] = horse2_b_;
    }

    public boolean checkisempty_w(int x, int y) {
        for (int i = 0; i < 16; i++) {
            if (mohre[i].getx() == x && mohre[i].gety() == y) {
                System.out.println("cant move");
                return false;
            }
        }
        return true;
    }

    public boolean checkisempty_b(int x, int y) {
        for (int i = 0; i < 16; i++) {
            if (mohre_b[i].getx() == x && mohre_b[i].gety() == y) {
                System.out.println("cant move");
                return false;
            }
        }
        return true;
    }

    public boolean checkisempty_b2(int x, int y) {
        for (int i = 0; i < 16; i++) {
            if (mohre_b[i].getx() == x && mohre_b[i].gety() == 7 - y) {
                System.out.println("cant move");
                return false;
            }
        }
        return true;
    }

    public boolean checkisempty_w2(int x, int y) {
        for (int i = 0; i < 16; i++) {
            if (mohre[i].getx() == x && mohre[i].gety() == 7 - y) {
                System.out.println("cant move");
                return false;
            }
        }
        return true;
    }

    public void guid() {
        System.out.println("0 to 7: sarbaz\n8 to 9:rokh\n10:king\n11 to 12: vazir\n"
                + "12 to 13: phil\n14 to 15: horse\n");
    }

    boolean flag = true;

    public void game_start() {
        int xx;
        int yy;
        const_black();
        const_white();
        while (true) {
            if (flag == true) {
                System.out.println("the white teams's turn---------");
            }
            if (flag == false) {
                System.out.println("the black teams's turn------");
            }
            guid();
            System.err.println("input the id:");
            int id1 = input.nextInt();
            System.err.println("input the x:");
            xx = input.nextInt();
            System.err.println("input the y:");
            yy = input.nextInt();

            if (flag == true) {
                if (checkisempty_w(xx, yy) == true) {
                    if (checkisempty_b2(xx, yy) == true) {
                        mohre[id1].move(xx, yy, mohre,mohre_b);
                        if (mohre[id1].getcheck2() == 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                }
            } else {
                if (checkisempty_b(xx, yy) == true) {
                    if(checkisempty_w2(xx, yy)==true)
                    {
                    mohre_b[id1].move(xx, yy,mohre,mohre_b);
                    if (mohre_b[id1].getcheck2() == 0) {
                        flag = false;
                    } else {
                        flag = true;
                    }                   
                    }
                }
            }
            if (id1 == -1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        chess ch = new chess();
        ch.game_start();
    }
}

abstract class Mohre {

    private int x;
    private int y;
    private int check2;
    protected int id;
    protected String color;
    protected String team;

    public int getx() {
        return x;
    }

    public void setx(int x) {
        this.x = x;
    }

    public int gety() {
        return y;
    }

    public void sety(int y) {
        this.y = y;

    }

    public void setcheck2(int check2) {
        this.check2 = check2;
    }

    public int getcheck2() {
        return check2;
    }

    public abstract void move(int x, int y, Mohre mohre1[],Mohre mohre_b1[]);

    /**
     * @param args the command line arguments
     */
}

class sarbaz extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        int counter = 0;
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            if (x2 - this.getx() != 0) {
                System.out.println("no1");
                System.out.println(this.getx() + "   " + this.gety());
            }

            if (x2 - this.getx() == 0 && y2 - this.gety() == 2) {
                if (this.getx() == this.id && this.gety() == 1) {
                    this.setx(x2);
                    this.sety(y2);
                    System.out.println("ok");
                    System.out.println(this.getx() + "   " + this.gety());
                    counter++;
                } else {
                    System.out.println("no2");
                    System.out.println(this.getx() + "   " + this.gety());
                    counter++;
                }
            }
            if (x2 - this.getx() == 0 && y2 - this.gety() == 1) {
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
                counter++;

            }
            if (x2 - this.getx() == 0 && y2 - this.gety() < 0) {
                System.out.println("no3");
                System.out.println(this.getx() + "   " + this.gety());
                counter++;
            }
            if (x2 - this.getx() == 0 && y2 - this.gety() != 1 && counter == 0) {
                System.out.println("no4");
                System.out.println(this.getx() + "   " + this.gety());
            }

        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
        

    }

    public sarbaz(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public sarbaz() {

    }
}

class rokh extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            
            for(int i =0;i<mohre1.length;i++)
            {
                
            }
            
            
            
            
            
            if ((x2 - this.getx() != 0 && y2 - this.gety() == 0) || (x2 - this.getx() == 0 && y2 - this.gety() != 0)) {
                
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
            } else {
                System.out.println("no5");
                System.out.println(this.getx() + "   " + this.gety());
            }
        } else {
            System.out.println("no6");
            System.out.println(this.getx() + "   " + this.gety());
        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
    }

    public rokh(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public rokh() {

    }
}

class king extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            if ((x2 - this.getx() == 1 && y2 - this.gety() == 0) || (x2 - this.getx() == -1 && y2 - this.gety() == 0)
                    || (y2 - this.gety() == 1 && x2 - this.getx() == 0) || (x2 - this.getx() == 0 && y2 - this.gety() == -1)
                    || (x2 - this.getx() == 1 && y2 - this.gety() == 1) || (x2 - this.getx() == -1 && y2 - this.gety() == -1)
                    || (x2 - this.getx() == 1 && y2 - this.gety() == -1) || (x2 - this.getx() == -1 && y2 - this.gety() == 1)) {
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
            } else {
                System.out.println("no7");
                System.out.println(this.getx() + "   " + this.gety());
            }
        } else {
            System.out.println("no8");
            System.out.println(this.getx() + "   " + this.gety());
        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
    }

    public king(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public king() {

    }
}

class vazir extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            if ((x2 - this.getx() != 0 && y2 - this.gety() == 0) || (x2 - this.getx() == 0 && y2 - this.gety() != 0)
                    || (x2 - this.getx() == (y2 - this.gety())) || (x2 - this.getx() == -(y2 - this.gety()))) {
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
            } else {
                System.out.println("no9");
                System.out.println(this.getx() + "   " + this.gety());
            }

        } else {
            System.out.println("no10");
            System.out.println(this.getx() + "   " + this.gety());
        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
    }

    public vazir(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public vazir() {

    }
}

class fil extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            if ((x2 - this.getx() == (y2 - this.gety())) || (x2 - this.getx() == -(y2 - this.gety()))) {
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
            } else {
                System.out.println("no11");
                System.out.println(this.getx() + "   " + this.gety());
            }

        } else {
            System.out.println("no12");
            System.out.println(this.getx() + "   " + this.gety());
        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
    }

    public fil(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public fil() {

    }
}

class horse extends Mohre {

    Scanner input = new Scanner(System.in);

    @Override
    public void move(int x1, int y1, Mohre mohre1[],Mohre mohre_b1[]) {
        int x2 = x1;
        int y2 = y1;
        int x_check = this.getx();
        int y_check = this.gety();
        if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
            if (((Math.abs(x2 - this.getx()) == 2) && (Math.abs(y2 - this.gety())) == 1)
                    || ((Math.abs(x2 - this.getx()) == 1) && Math.abs(y2 - this.gety()) == 2)) {
                this.setx(x2);
                this.sety(y2);
                System.out.println("ok");
                System.out.println(this.getx() + "   " + this.gety());
            } else {
                System.out.println("no13");
                System.out.println(this.getx() + "   " + this.gety());
            }
        } else {
            System.out.println("no14");
            System.out.println(this.getx() + "   " + this.gety());
        }
        if (x_check - this.getx() == 0 && y_check - this.gety() == 0) {
            this.setcheck2(0);
        } else {
            this.setcheck2(1);
        }
    }

    public horse(int x, int y, int id, String color, String team) {
        this.setx(x);
        this.sety(y);
        this.id = id;
        this.color = color;
        this.team = team;
    }

    public horse() {

    }
}
