package Main;

import Entity.Entity;

public class CollisionChecker
{
    GamePanel gamePanel;
    public CollisionChecker(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    /**
     * method to determine collision with tile - the topleft, top right, botton left and bottom right are decided to be the solid areas
     * @param entity
     */
    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;


        int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol = entityRightWorldX/gamePanel.tileSize;
        int entityTopRow = entityTopWorldY/gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY/gamePanel.tileSize;

        int tileNum1 , tileNum2;
        switch (entity.direction)
        {
            case "up":
                entityTopRow = (entityTopWorldY-entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }

                break;
            case "down":
                entityBottomRow = (entityBottomWorldY+entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX-entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX+entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
        }


    }
    public int checkObject(Entity entity, boolean player)
    {
        int index = 999;

        for(int i = 0; i< gamePanel.obj.length; i++)
        {
            if(gamePanel.obj[i] != null)
            {
                // GET ENTITY"S SOLID AREA POSITION
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;


                // GET OBJECTS SOLID AREA POSITION

                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;



                switch (entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea))
                        {
                            // check if two rects are colliding or not
                            if(gamePanel.obj[i].collision==true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea))
                        {
                            // check if two rects are colliding or not
                            if(gamePanel.obj[i].collision==true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea))
                        {
                            // check if two rects are colliding or not
                            if(gamePanel.obj[i].collision==true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea))
                        {
                            // check if two rects are colliding or not
                            if(gamePanel.obj[i].collision==true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;

            }
        }

        return index;
    }
}
