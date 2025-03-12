package se.loge.bwcontrol.mpk.hardware;

import com.bitwig.extension.controller.api.HardwareSurface;
import com.bitwig.extension.controller.api.MidiIn;
import com.bitwig.extension.controller.api.MidiOut;

public class HWControlBankC extends HWControlBank {
  static final String CONTROL_BANK_ID = "C";

  // TODO set correct values
  static final int CONTROL_BANK_MIDI_CHANNEL = 0;
  static final int[] CONTROL_BANK_KNOB_CC = { 83, 85, 86, 87, 88, 89, 90, 91 };
  static final int[] CONTROL_BANK_FADER_CC = { 92, 93, 94, 95, 102, 103, 104, 105};
  static final int[] CONTROL_BANK_SOLO_CC = { 106, 107, 108, 109, 110, 111, 112, 113 };

  static final int CONTROL_BANK_SOLO_PRESSED_VAL = 127;

  public HWControlBankC(HardwareSurface surface) {
    super(surface, CONTROL_BANK_ID);
  }

  @Override
  public void connectMidiIn(MidiIn midiIn, MidiIn... midiIns) {
    for (int i = 0; i < MPK261_NUM_CONTROL_STRIPS; i++) {
      S[i].pressedAction().setActionMatcher(
        midiIn.createCCActionMatcher(CONTROL_BANK_MIDI_CHANNEL,
          CONTROL_BANK_SOLO_CC[i], CONTROL_BANK_SOLO_PRESSED_VAL));

      F[i].setAdjustValueMatcher(midiIn.createAbsoluteCCValueMatcher(
        CONTROL_BANK_MIDI_CHANNEL, CONTROL_BANK_FADER_CC[i]));

      K[i].setAdjustValueMatcher(midiIn.createRelative2sComplementCCValueMatcher(
        CONTROL_BANK_MIDI_CHANNEL, CONTROL_BANK_KNOB_CC[i], KNOB_ROTATION_VAL));
    }
  }

  @Override
  public void bindCCActions() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void connectMidiOut(MidiOut midiOut, MidiOut... midiIns) {
    // TODO Auto-generated method stub
    
  }

}
