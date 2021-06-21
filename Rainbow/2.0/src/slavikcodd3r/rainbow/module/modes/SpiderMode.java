package slavikcodd3r.rainbow.module.modes;

import slavikcodd3r.rainbow.event.events.BoundingBoxEntityEvent;
import slavikcodd3r.rainbow.event.events.BoundingBoxEvent;
import slavikcodd3r.rainbow.event.events.MoveEvent;
import slavikcodd3r.rainbow.event.events.PacketReceiveEvent;
import slavikcodd3r.rainbow.event.events.PacketSendEvent;
import slavikcodd3r.rainbow.event.events.UpdateEvent;
import slavikcodd3r.rainbow.module.Module;
import slavikcodd3r.rainbow.option.Option;
import slavikcodd3r.rainbow.option.OptionManager;
import slavikcodd3r.rainbow.option.types.BooleanOption;

public class SpiderMode extends BooleanOption
{
    public SpiderMode(final String name, final boolean value, final Module module) {
        super(name, name, value, module);
    }
    
    @Override
    public void setValue(final Boolean value) {
        if (value) {
            for (final Option option : OptionManager.getOptionList()) {
                if (option.getModule().equals(this.getModule()) && option instanceof SpiderMode) {
                    ((BooleanOption)option).setValueHard(false);
                }
            }
        }
        else {
            for (final Option option : OptionManager.getOptionList()) {
                if (option.getModule().equals(this.getModule()) && option instanceof SpiderMode && option != this) {
                    ((BooleanOption)option).setValueHard(true);
                    break;
                }
            }
        }
        super.setValue(value);
    }
    
    public boolean enable() {
        return this.getValue();
    }
    
    public boolean onUpdate(final UpdateEvent event) {
        return this.getValue();
    }
    
    public boolean onPacket(final PacketSendEvent event) {
        return this.getValue();
    }
    
    public boolean onPacket(final PacketReceiveEvent event) {
        return this.getValue();
    }
    
    public boolean onMove(final MoveEvent event) {
        return this.getValue();
    }    
    
    public boolean onBB(final BoundingBoxEntityEvent event) {
        return this.getValue();
    }
    
    public boolean onSetBB(final BoundingBoxEvent event) {
    	return this.getValue();
    }
    
    public boolean disable() {
        return true;
    }
}