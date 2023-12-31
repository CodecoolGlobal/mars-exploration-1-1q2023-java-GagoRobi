package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Boss;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Princess;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.actors.Troll;
import com.codecool.dungeoncrawl.data.doors.Door;
import com.codecool.dungeoncrawl.data.items.HpPotion;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Sword;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.setSkeleton(new Skeleton(cell));
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            map.setSkeleton2(new Skeleton(cell));
                            map.getSkeleton2().setTileName("skeleton2");
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case '-':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new HpPotion(cell);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            new Door(cell);
                            break;
                        case'p':
                            cell.setType(CellType.FLOOR);
                            new Princess(cell);
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            map.setBoss(new Boss(cell));
                            break;
                        case 'w':
                            cell.setType(CellType.WEB);
                            break;
                        case 'F':
                            cell.setType(CellType.FIRE);
                            break;
                        case 'c':
                            cell.setType(CellType.CANDLE);
                            break;
                        case 't':
                            cell.setType(CellType.FLOOR);
                            map.setTroll(new Troll(cell));
                            cell.getActor().setHealth(15);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
