package com.mawuote.api.manager.event.impl.entity;

import com.mawuote.api.manager.event.*;
import net.minecraft.entity.*;

public class EventEntity extends Event
{
    private Entity entity;
    
    public EventEntity(final Entity entity) {
        this.entity = entity;
    }
    
    public Entity get_entity() {
        return this.entity;
    }
    
    public static class EventColision extends EventEntity
    {
        private double x;
        private double y;
        private double z;
        
        public EventColision(final Entity entity, final double x, final double y, final double z) {
            super(entity);
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        public void set_x(final double x) {
            this.x = x;
        }
        
        public void set_y(final double y) {
            this.y = y;
        }
        
        public void set_z(final double x) {
            this.z = this.z;
        }
        
        public double get_x() {
            return this.x;
        }
        
        public double get_y() {
            return this.y;
        }
        
        public double get_z() {
            return this.z;
        }
    }
}
