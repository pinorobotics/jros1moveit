/*
 * Copyright 2021 jrosmoveit project
 * 
 * Website: https://github.com/pinorobotics/jros1moveit
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.jros1moveit.moveit_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for moveit_msgs/MotionSequenceItem */
@MessageMetadata(
        name = MotionSequenceItemMessage.NAME,
        fields = {"req", "blend_radius"},
        md5sum = "605a152161827d49a0abacf6c6544d1e")
public class MotionSequenceItemMessage implements Message {

    static final String NAME = "moveit_msgs/MotionSequenceItem";

    /**
     * The plan request for this item. It is the planning request for this segment of the sequence,
     * as if it were a solitary motion.
     */
    public MotionPlanRequestMessage req = new MotionPlanRequestMessage();

    /**
     * To blend between sequence items, the motion may be smoothed using a circular motion. The
     * blend radius of the circle between this and the next command, where 0 means no blending.
     */
    public double blend_radius;

    public MotionSequenceItemMessage withReq(MotionPlanRequestMessage req) {
        this.req = req;
        return this;
    }

    public MotionSequenceItemMessage withBlendRadius(double blend_radius) {
        this.blend_radius = blend_radius;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(req, blend_radius);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MotionSequenceItemMessage) obj;
        return Objects.equals(req, other.req) && blend_radius == other.blend_radius;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "req", req,
                "blend_radius", blend_radius);
    }
}
