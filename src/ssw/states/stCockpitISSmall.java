/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package ssw.states;

import ssw.Constants;
import ssw.components.*;

public class stCockpitISSmall implements ifCockpit, ifState {
    private final static AvailableCode AC = new AvailableCode( false, 'E', 'X', 'X', 'E',
        3067, 0, 0, "FS", "", false, false );
    private final static SimplePlaceable Sensors = new SimplePlaceable( "Sensors",
        "Sensors", 1, true, AC );
    private final static SimplePlaceable LifeSupport = new SimplePlaceable( "Life Support",
        "Life Support", 1, true, AC );
    private final static SimplePlaceable SecondSensors = new SimplePlaceable( "Sensors",
        "Sensors", 1, true, AC );
    private final static SimplePlaceable SecondLifeSupport = new SimplePlaceable( "Life Support",
        "Life Support", 1, true, AC );
    private final MechModifier MechMod = new MechModifier( 0, 0, 0, 0.0f, 1, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, true );

    public stCockpitISSmall() {
        AC.SetRulesLevelIM( Constants.UNALLOWED );
    }

    public boolean IsClan() {
        return false;
    }
    
    public float GetTonnage() {
        float result = 2.0f;
        result += Sensors.GetTonnage();
        result += SecondSensors.GetTonnage();
        result += LifeSupport.GetTonnage();
        return result;
    }

    public int GetSecondSensorLoc() {
        // This returns the head index number of the second sensor location
        // it'll be one less than the game says because it's an array index
        return 3;
    }
    
    public boolean HasSecondLSLoc() {
        return false;
    }

    public SimplePlaceable GetLifeSupport() {
        return LifeSupport;
    }
    
    public SimplePlaceable GetSensors() {
        return Sensors;
    }

    public SimplePlaceable GetSecondLifeSupport() {
        return SecondLifeSupport;
    }
    
    public SimplePlaceable GetSecondSensors() {
        return SecondSensors;
    }

    public String GetLookupName() {
        return "Small Cockpit";
    }

    public String GetCritName() {
        return "Small Cockpit";
    }

    public String GetMMName() {
        return "Cockpit";
    }

    public String GetReportName() {
        return "Small";
    }

    public float GetCost( int Tonnage ) {
        float result = 225000.0f + ( 2000.0f * Tonnage );
        result += Sensors.GetCost();
        result += LifeSupport.GetCost();
        result += SecondSensors.GetCost();
        result += SecondLifeSupport.GetCost();
        return result;
    }
    
    public boolean HasFireControl() {
        return true;
    }

    public float BVMod() {
        return 0.95f;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }

    public int ReportCrits() {
        return 4;
    }

    public MechModifier GetMechModifier() {
        return MechMod;
    }

    @Override
    public String toString() {
        return "Small Cockpit";
    }
}
