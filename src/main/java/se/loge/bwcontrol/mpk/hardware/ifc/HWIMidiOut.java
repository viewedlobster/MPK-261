package se.loge.bwcontrol.mpk.hardware.ifc;

import com.bitwig.extension.controller.api.MidiOut;

public interface HWIMidiOut {
  public void connectMidiOut(MidiOut midiOut, MidiOut... midiIns);
}
