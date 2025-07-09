/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package constants.inventory;

import client.inventory.InventoryType;
import config.YamlConfig;
import constants.id.ItemId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jay Estrella
 * @author Ronan
 */
public final class ItemConstants {
    protected static Map<Integer, InventoryType> inventoryTypeCache = new HashMap<>();

    public final static short LOCK = 0x01;
    public final static short SPIKES = 0x02;
    public final static short KARMA_USE = 0x02;
    public final static short COLD = 0x04;
    public final static short UNTRADEABLE = 0x08;
    public final static short KARMA_EQP = 0x10;
    public final static short SANDBOX = 0x40;             // let 0x40 until it's proven something uses this
    public final static short PET_COME = 0x80;
    public final static short ACCOUNT_SHARING = 0x100;
    public final static short MERGE_UNTRADEABLE = 0x200;
    public final static int STORAGE_MAX_SLOT_SIZE = 255;

    public final static Set<Integer> extraStorageFilter = new HashSet<>(Arrays.asList( //Only ores, scrolls, skillbooks
            4004000, 4004001, 4004002, 4004003, 4004004, 4005000, 4005001,
            4005002, 4005003, 4005004, 4007000, 4007001, 4007002, 4007003,
            4007004, 4007005, 4007006, 4007007, 4010000, 4010001, 4010002,
            4010003, 4010004, 4010005, 4010006, 4010007, 4011000, 4011001,
            4011002, 4011003, 4011004, 4011005, 4011006, 4011007, 4011008,
            4020000, 4020001, 4020002, 4020003, 4020004, 4020005, 4020006,
            4020007, 4020008, 4020009, 4021000, 4021001, 4021002, 4021003,
            4021004, 4021005, 4021006, 4021007, 4021008, 4021009, 4021010,
            4250000, 4250001, 4250002, 4250100, 4250101, 4250102, 4250200,
            4250201, 4250202, 4250300, 4250301, 4250302, 4250400, 4250401,
            4250402, 4250500, 4250501, 4250502, 4250600, 4250601, 4250602,
            4250700, 4250701, 4250702, 4250800, 4250801, 4250802, 4250900,
            4250901, 4250902, 4251000, 4251001, 4251002, 4251100, 4251101,
            4251102, 4251200, 4251201, 4251202, 4251300, 4251301, 4251302,
            4251400, 4251401, 4251402, 4260000, 4260001, 4260002, 4260003,
            4260004, 4260005, 4260006, 4260007, 4260008,
            2040023, 2040024, 2040025, 2040026, 2040027, 2040028, 2040029, //SoupMS - Start of scrolls
            2040030, 2040031, 2040316, 2040317, 2040318, 2040319, 2040320,
            2040321, 2040322, 2040323, 2040324, 2040325, 2040326, 2040327,
            2040328, 2040417, 2040418, 2040419, 2040420, 2040421, 2040422,
            2040423, 2040424, 2040425, 2040426, 2040427, 2040530, 2040531,
            2040532, 2040533, 2040534, 2040617, 2040618, 2040619, 2040620,
            2040621, 2040622, 2040623, 2040624, 2040625, 2040626, 2040627,
            2040727, 2040823, 2040824, 2040825, 2040923, 2040924, 2040925,
            2040926, 2040927, 2040928, 2040929, 2040930, 2040931, 2040932,
            2040933, 2041058, 2041059, 2041060, 2041061, 2041062, 2043015,
            2043016, 2043017, 2043018, 2043019, 2043110, 2043111, 2043112,
            2043113, 2043114, 2043210, 2043211, 2043212, 2043213, 2043214,
            2044010, 2044011, 2044012, 2044013, 2044014, 2044110, 2044111,
            2044112, 2044113, 2044114, 2044210, 2044211, 2044212, 2044213,
            2044214, 2044310, 2044311, 2044312, 2044313, 2044314, 2044410,
            2044411, 2044412, 2044413, 2044414, 2044800, 2044801, 2044803,
            2044804, 2044805, 2044806, 2044807, 2044808, 2044809, 2044810,
            2044900, 2044901, 2044903, 2044904, 2044905, 2048010, 2048011,
            2048012, 2048013, 2049000, 2049001, 2049002, 2049003, 2049100,
            2049101, 2049102, 2049104, 2040110, 2040111, 2040112, 2040113,
            2040114, 2040115, 2040116, 2040117, 2040118, 2040119, 2044811,
            2044812, 2044813, 2044814, 2044906, 2044907, 2049103, 2044712,
            2044612, 2044512, 2044417, 2044317, 2044217, 2044117, 2044025,
            2043812, 2043712, 2043312, 2043217, 2043117, 2043023, 2041066,
            2041067, 2040936, 2040829, 2040830, 2040740, 2040741, 2040742,
            2040630, 2040538, 2040539, 2040430, 2040334, 2040041, 2040042,
            2040329, 2040330, 2040331, 2040728, 2040729, 2040730, 2040731,
            2040732, 2040733, 2040734, 2040735, 2040736, 2040737, 2040738,
            2040739, 2040826, 2041100, 2041101, 2041102, 2041103, 2041104,
            2041105, 2041106, 2041107, 2041108, 2041109, 2041110, 2041111,
            2041112, 2041113, 2041114, 2041115, 2041116, 2041117, 2041118,
            2041119, 2041300, 2041301, 2041302, 2041303, 2041304, 2041305,
            2041306, 2041307, 2041308, 2041309, 2041310, 2041311, 2041312,
            2041313, 2041314, 2041315, 2041316, 2041317, 2041318, 2041319,
            2044015, 2049105, 2049106, 2049107, 2049108, 2049109, 2049110,
            2044713, 2044613, 2044513, 2044420, 2044320, 2044220, 2044120,
            2044028, 2043813, 2043713, 2043313, 2043220, 2043120, 2043022,
            2041068, 2041069, 2040943, 2040833, 2040834, 2040755, 2040756,
            2040757, 2040629, 2040542, 2040543, 2040429, 2040333, 2040045,
            2040046, 2043021, 2043116, 2043216, 2043311, 2043711, 2043811,
            2044024, 2044116, 2044216, 2044316, 2044416, 2044511, 2044611,
            2044711, 2044816, 2044909, 2049112, 2044815, 2044817, 2044908,
            2044910, 2049200, 2049201, 2049202, 2049203, 2049204, 2049205,
            2049206, 2049207, 2049208, 2049209, 2049210, 2049211, 2044418,
            2044419, 2044318, 2044319, 2044218, 2044219, 2044118, 2044119,
            2044026, 2044027, 2043218, 2043219, 2043118, 2043119, 2043024,
            2043025, 2040937, 2040938, 2040939, 2040940, 2040941, 2040942,
            2040831, 2040832, 2040631, 2040632, 2040633, 2040634, 2040635,
            2040636, 2040540, 2040541, 2040431, 2040432, 2040433, 2040434,
            2040435, 2040436, 2040335, 2040336, 2040337, 2040338, 2040339, //SoupMS End of Scrolls
            2040340, 2040043, 2040044, 2280003, 2280004, 2280005, 2280006, 2280007, 2280008, 2280009,
            2280010, 2280012, 2280013, 2280014, 2280015, 2280016, 2280017, //SoupMS Start of Mastery Books
            2280018, 2280019, 2290000, 2290001, 2290002, 2290003, 2290004,
            2290005, 2290006, 2290007, 2290008, 2290009, 2290010, 2290011,
            2290012, 2290013, 2290014, 2290015, 2290016, 2290017, 2290018,
            2290019, 2290020, 2290021, 2290022, 2290023, 2290024, 2290025,
            2290026, 2290027, 2290028, 2290029, 2290030, 2290031, 2290032,
            2290033, 2290034, 2290035, 2290036, 2290037, 2290038, 2290039,
            2290040, 2290041, 2290042, 2290043, 2290044, 2290045, 2290046,
            2290047, 2290048, 2290049, 2290050, 2290051, 2290052, 2290053,
            2290054, 2290055, 2290056, 2290057, 2290058, 2290059, 2290060,
            2290061, 2290062, 2290063, 2290064, 2290065, 2290066, 2290067,
            2290068, 2290069, 2290070, 2290071, 2290072, 2290073, 2290074,
            2290075, 2290076, 2290077, 2290078, 2290079, 2290080, 2290081,
            2290082, 2290083, 2290084, 2290085, 2290086, 2290087, 2290088,
            2290089, 2290090, 2290091, 2290092, 2290093, 2290094, 2290095,
            2290096, 2290097, 2290098, 2290099, 2290100, 2290101, 2290102,
            2290103, 2290104, 2290105, 2290106, 2290107, 2290108, 2290109,
            2290110, 2290111, 2290112, 2290113, 2290114, 2290115, 2290116,
            2290117, 2290118, 2290119, 2290120, 2290121, 2290122, 2290123,
            2290124, 2290125, 2290126, 2290127, 2290128, 2290129, 2290130,
            2290131, 2290132, 2290133, 2290134, 2290135, 2290136, 2290137,
            2290138, 2290139                                                //End of Mastery and Skill books

    ));

    public final static boolean EXPIRING_ITEMS = true;
    public final static Set<Integer> permanentItemids = new HashSet<>();

    static {
        // i ain't going to open one gigantic itemid cache just for 4 perma itemids, no way!
        for (int petItemId : ItemId.getPermaPets()) {
            permanentItemids.add(petItemId);
        }
    }

    public static int getFlagByInt(int type) {
        if (type == 128) {
            return PET_COME;
        } else if (type == 256) {
            return ACCOUNT_SHARING;
        }
        return 0;
    }

    public static boolean isThrowingStar(int itemId) {
        return itemId / 10000 == 207;
    }

    public static boolean isBullet(int itemId) {
        return itemId / 10000 == 233;
    }

    public static boolean isPotion(int itemId) {
        return itemId / 1000 == 2000;
    }

    public static boolean isFood(int itemId) {
        int useType = itemId / 1000;
        return useType == 2022 || useType == 2010 || useType == 2020;
    }

    public static boolean isConsumable(int itemId) {
        return isPotion(itemId) || isFood(itemId);
    }

    public static boolean isRechargeable(int itemId) {
        return isThrowingStar(itemId) || isBullet(itemId);
    }

    public static boolean isArrowForCrossBow(int itemId) {
        return itemId / 1000 == 2061;
    }

    public static boolean isArrowForBow(int itemId) {
        return itemId / 1000 == 2060;
    }

    public static boolean isArrow(int itemId) {
        return isArrowForBow(itemId) || isArrowForCrossBow(itemId);
    }

    public static boolean isPet(int itemId) {
        return itemId / 1000 == 5000;
    }

    public static boolean isExpirablePet(int itemId) {
        return YamlConfig.config.server.USE_ERASE_PET_ON_EXPIRATION || itemId == ItemId.PET_SNAIL;
    }

    public static boolean isPermanentItem(int itemId) {
        return permanentItemids.contains(itemId);
    }

    public static boolean isNewYearCardEtc(int itemId) {
        return itemId / 10000 == 430;
    }

    public static boolean isNewYearCardUse(int itemId) {
        return itemId / 10000 == 216;
    }

    public static boolean isAccessory(int itemId) {
        return itemId >= 1110000 && itemId < 1140000;
    }

    public static boolean isTaming(int itemId) {
        int itemType = itemId / 1000;
        return itemType == 1902 || itemType == 1912;
    }

    public static boolean isTownScroll(int itemId) {
        return itemId >= 2030000;
    }

    public static boolean isCleanSlate(int scrollId) {
        return scrollId > 2048999 && scrollId < 2049004;
    }

    public static boolean isModifierScroll(int scrollId) {
        return scrollId == ItemId.SPIKES_SCROLL || scrollId == ItemId.COLD_PROTECTION_SCROLl;
    }

    public static boolean isFlagModifier(int scrollId, short flag) {
        if (scrollId == ItemId.COLD_PROTECTION_SCROLl && ((flag & ItemConstants.COLD) == ItemConstants.COLD)) {
            return true;
        }
        return scrollId == ItemId.SPIKES_SCROLL && ((flag & ItemConstants.SPIKES) == ItemConstants.SPIKES);
    }

    public static boolean isChaosScroll(int scrollId) {
        return scrollId >= 2049100 && scrollId <= 2049103;
    }

    public static boolean isRateCoupon(int itemId) {
        int itemType = itemId / 1000;
        return itemType == 5211 || itemType == 5360;
    }

    public static boolean isExpCoupon(int couponId) {
        return couponId / 1000 == 5211;
    }

    public static boolean isPartyItem(int itemId) {
        return itemId >= 2022430 && itemId <= 2022433 || itemId >= 2022160 && itemId <= 2022163;
    }

    public static boolean isHiredMerchant(int itemId) {
        return itemId / 10000 == 503;
    }

    public static boolean isPlayerShop(int itemId) {
        return itemId / 10000 == 514;
    }

    public static InventoryType getInventoryType(final int itemId) {
        if (inventoryTypeCache.containsKey(itemId)) {
            return inventoryTypeCache.get(itemId);
        }

        InventoryType ret = InventoryType.UNDEFINED;

        final byte type = (byte) (itemId / 1000000);
        if (type >= 1 && type <= 5) {
            ret = InventoryType.getByType(type);
        }

        inventoryTypeCache.put(itemId, ret);
        return ret;
    }

    public static boolean isMakerReagent(int itemId) {
        return itemId / 10000 == 425;
    }

    public static boolean isOverall(int itemId) {
        return itemId / 10000 == 105;
    }

    public static boolean isCashStore(int itemId) {
        int itemType = itemId / 10000;
        return itemType == 503 || itemType == 514;
    }

    public static boolean isMapleLife(int itemId) {
        int itemType = itemId / 10000;
        return itemType == 543 && itemId != 5430000;
    }

    public static boolean isWeapon(int itemId) {
        return itemId >= 1302000 && itemId < 1493000;
    }

    public static boolean isEquipment(int itemId) {
        return itemId < 2000000 && itemId != 0;
    }

    public static boolean isFishingChair(int itemId) {
        return itemId == ItemId.FISHING_CHAIR;
    }

    public static boolean isMedal(int itemId) {
        return itemId >= 1140000 && itemId < 1143000;
    }

    public static boolean isFace(int itemId) {
        return itemId >= 20000 && itemId < 22000;
    }

    public static boolean isHair(int itemId) {
        return itemId >= 30000 && itemId < 35000;
    }
}
