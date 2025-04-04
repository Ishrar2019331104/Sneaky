package Main;

import WorldObject.*;

public class AssetSetter{
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    /**
     * places objects - letters, acid, insect on the map.
     */
    public void setObject()
    {
        gamePanel.obj[0] = new A();
        gamePanel.obj[0].worldX = 2 * gamePanel.tileSize;
        gamePanel.obj[0].worldY = 4 * gamePanel.tileSize;

        gamePanel.obj[1] = new Insect();
        gamePanel.obj[1].worldX = 2 * gamePanel.tileSize;
        gamePanel.obj[1].worldY = 31 * gamePanel.tileSize;

        gamePanel.obj[2] = new B();
        gamePanel.obj[2].worldX = 11 * gamePanel.tileSize;
        gamePanel.obj[2].worldY = 6 * gamePanel.tileSize;

        gamePanel.obj[3] = new D();
        gamePanel.obj[3].worldX = 38 * gamePanel.tileSize;
        gamePanel.obj[3].worldY = 25 * gamePanel.tileSize;

        gamePanel.obj[4] = new C();
        gamePanel.obj[4].worldX = 19 * gamePanel.tileSize;
        gamePanel.obj[4].worldY = 13 * gamePanel.tileSize;

        gamePanel.obj[5] = new Acid();
        gamePanel.obj[5].worldX = 37 * gamePanel.tileSize;
        gamePanel.obj[5].worldY = 25 * gamePanel.tileSize;

        gamePanel.obj[6] = new E();
        gamePanel.obj[6].worldX = 20 * gamePanel.tileSize;
        gamePanel.obj[6].worldY = 27 * gamePanel.tileSize;

        gamePanel.obj[7] = new F();
        gamePanel.obj[7].worldX = 9 * gamePanel.tileSize;
        gamePanel.obj[7].worldY = 32 * gamePanel.tileSize;

        gamePanel.obj[8] = new G();
        gamePanel.obj[8].worldX = 33 * gamePanel.tileSize;
        gamePanel.obj[8].worldY = 35 * gamePanel.tileSize;

        gamePanel.obj[9] = new L();
        gamePanel.obj[9].worldX = 36 * gamePanel.tileSize;
        gamePanel.obj[9].worldY = 14 * gamePanel.tileSize;

        gamePanel.obj[10] = new Insect();
        gamePanel.obj[10].worldX = 43 * gamePanel.tileSize;
        gamePanel.obj[10].worldY = 18 * gamePanel.tileSize;

        gamePanel.obj[11] = new O();
        gamePanel.obj[11].worldX = 8 * gamePanel.tileSize;
        gamePanel.obj[11].worldY = 43 * gamePanel.tileSize;

        gamePanel.obj[12] = new H();
        gamePanel.obj[12].worldX = 33 * gamePanel.tileSize;
        gamePanel.obj[12].worldY = 39 * gamePanel.tileSize;

        gamePanel.obj[13] = new S();
        gamePanel.obj[13].worldX = 18 * gamePanel.tileSize;
        gamePanel.obj[13].worldY = 13 * gamePanel.tileSize;

        gamePanel.obj[14] = new T();
        gamePanel.obj[14].worldX = 40 * gamePanel.tileSize;
        gamePanel.obj[14].worldY = 1 * gamePanel.tileSize;

        gamePanel.obj[15] = new U();
        gamePanel.obj[15].worldX = 2 * gamePanel.tileSize;
        gamePanel.obj[15].worldY = 19 * gamePanel.tileSize;

        gamePanel.obj[16] = new Acid();
        gamePanel.obj[16].worldX = 39 * gamePanel.tileSize;
        gamePanel.obj[16].worldY = 7  * gamePanel.tileSize;

        gamePanel.obj[17] = new K();
        gamePanel.obj[17].worldX = 23 * gamePanel.tileSize;
        gamePanel.obj[17].worldY = 23 * gamePanel.tileSize;

        gamePanel.obj[18] = new Acid();
        gamePanel.obj[18].worldX = 9 * gamePanel.tileSize;
        gamePanel.obj[18].worldY = 17 * gamePanel.tileSize;

        gamePanel.obj[19] = new Acid();
        gamePanel.obj[19].worldX = 9 * gamePanel.tileSize;
        gamePanel.obj[19].worldY = 27 * gamePanel.tileSize;

        gamePanel.obj[20] = new I();
        gamePanel.obj[20].worldX = 13 * gamePanel.tileSize;
        gamePanel.obj[20].worldY = 31 * gamePanel.tileSize;

        gamePanel.obj[21] = new J();
        gamePanel.obj[21].worldX = 20 * gamePanel.tileSize;
        gamePanel.obj[21].worldY = 13 * gamePanel.tileSize;

        gamePanel.obj[22] = new M();
        gamePanel.obj[22].worldX = 10 * gamePanel.tileSize;
        gamePanel.obj[22].worldY = 14 * gamePanel.tileSize;

        gamePanel.obj[23] = new N();
        gamePanel.obj[23].worldX = 7 * gamePanel.tileSize;
        gamePanel.obj[23].worldY = 31 * gamePanel.tileSize;

        gamePanel.obj[24] = new Z();
        gamePanel.obj[24].worldX = 38 * gamePanel.tileSize;
        gamePanel.obj[24].worldY = 31 * gamePanel.tileSize;

        gamePanel.obj[25] = new X();
        gamePanel.obj[25].worldX = 5 * gamePanel.tileSize;
        gamePanel.obj[25].worldY = 30 *gamePanel.tileSize;

        gamePanel.obj[26] = new Acid();
        gamePanel.obj[26].worldX = 38 * gamePanel.tileSize;
        gamePanel.obj[26].worldY = 14 * gamePanel.tileSize;














    }
}