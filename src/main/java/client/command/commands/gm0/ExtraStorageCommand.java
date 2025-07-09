// created by Mark & Darnell

package client.command.commands.gm0;

import client.Character;
import client.Client;
import client.autoban.AutobanFactory;
import client.command.Command;
import client.inventory.Inventory;
import client.inventory.InventoryType;
import client.inventory.Item;
import client.inventory.manipulator.InventoryManipulator;
import client.inventory.manipulator.KarmaManipulator;
import constants.id.ItemId;
import constants.inventory.ItemConstants;
import server.ItemInformationProvider;
import server.ExtraStorage;
import tools.PacketCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraStorageCommand extends Command {
    {
        setDescription("Extra storage for ores, scrolls, skillbooks.");
    }

    @Override
    public void execute(Client c, String[] params) {
        Character player = c.getPlayer();
        ExtraStorage extraStorage = player.getExtraStorage();

        InventoryType invType = InventoryType.ETC;
        Inventory inv = player.getInventory(invType);

        if (params.length < 1) {
            player.yellowMessage("Syntax: @ExtraStorage <store | open>");
            return;
        }

        String action = params[0];

        switch (action) {
            case "store":
                ArrayList<Item> itemsToStoreAndRemove = new ArrayList<Item>(c.getPlayer().getInventory(invType).list());

                for (Item tempItem : itemsToStoreAndRemove) {
                    int itemId = tempItem.getItemId();

                    if (!ItemConstants.extraStorageFilter.contains(itemId)) {
                        continue;
                    }

                    short quantity = tempItem.getQuantity();

                    try {
                        inv.lockInventory();
                        InventoryManipulator.removeFromSlot(c, invType, tempItem.getPosition(), tempItem.getQuantity(), false);
                        tempItem = tempItem.copy();
                    } finally {
                        inv.unlockInventory();
                    }

                    KarmaManipulator.toggleKarmaFlagToUntradeable(tempItem);
                    tempItem.setQuantity(quantity);

                    boolean success = extraStorage.store(tempItem); // inside a critical section, "!(storage.isFull())" is still in effect...

                    player.setUsedExtraStorage();
                }
                break;
            case "open":
                player.setUsingExtraStorage(true);
                player.getExtraStorage().sendStorage(c, 9200000);
                c.sendPacket(PacketCreator.enableActions());
                break;
            case "disable":
                player.setUsingExtraStorage(false);
                break;
        }
    }
}