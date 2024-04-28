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

/** Definition for moveit_msgs/MoveGroupGoal */
@MessageMetadata(
        name = MoveGroupGoalMessage.NAME,
        fields = {"request", "planning_options"},
        md5sum = "ce7f9820670af166b2faa14c475891b0")
public class MoveGroupGoalMessage implements Message {

    static final String NAME = "moveit_msgs/MoveGroupGoal";

    /**
     * ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ====== Motion planning request
     * to pass to planner
     */
    public MotionPlanRequestMessage request = new MotionPlanRequestMessage();

    /** Planning options */
    public PlanningOptionsMessage planning_options = new PlanningOptionsMessage();

    public MoveGroupGoalMessage withRequest(MotionPlanRequestMessage request) {
        this.request = request;
        return this;
    }

    public MoveGroupGoalMessage withPlanningOptions(PlanningOptionsMessage planning_options) {
        this.planning_options = planning_options;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, planning_options);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MoveGroupGoalMessage) obj;
        return Objects.equals(request, other.request)
                && Objects.equals(planning_options, other.planning_options);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "request", request,
                "planning_options", planning_options);
    }
}
