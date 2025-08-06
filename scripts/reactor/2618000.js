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

/*2618000.js - MagatiaPQ Beaker
    Maps:
    926110100
    926100100
 *@author Ronan
 */

function hit() {
  //      rm.playerMessage(5, "Current state:" + rm.getReactor().getState());
    if (rm.getReactor().getState() >= 4) { //SoupMS - Stage 8 is actually the completed stage not sure why 6 was chosen
        var eim = rm.getEventInstance();  //Stage 6 was chosen because the hit code is on the current state. So 6 -> 7 and 7 auto goes to 8

        var done = eim.getIntProperty("statusStg3") + 1;
        eim.setIntProperty("statusStg3", done);

        if (done == 3) {
            eim.showClearEffect();
            eim.giveEventPlayersStageReward(3);
            rm.getMap().killAllMonsters();

            var reactname = (eim.getIntProperty("isAlcadno") == 0) ? "rnj2_door" : "jnr2_door";
            rm.getMap().getReactorByName(reactname).hitReactor(rm.getClient());
        }
    }
}

function act() {}