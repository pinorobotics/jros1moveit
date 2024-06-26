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
import id.jrosmessages.std_msgs.Int32Message;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for moveit_msgs/PlanningOptions */
@MessageMetadata(
        name = PlanningOptionsMessage.NAME,
        fields = {
            "planning_scene_diff",
            "plan_only",
            "look_around",
            "look_around_attempts",
            "max_safe_execution_cost",
            "replan",
            "replan_attempts",
            "replan_delay"
        },
        md5sum = "3134e041c806c7c2ff59948db4d57835")
public class PlanningOptionsMessage implements Message {

    static final String NAME = "moveit_msgs/PlanningOptions";

    /** The diff to consider for the planning scene (optional) */
    public PlanningSceneMessage planning_scene_diff = new PlanningSceneMessage();

    /**
     * If this flag is set to true, the action returns an executable plan in the response but does
     * not attempt execution
     */
    public boolean plan_only;

    /**
     * If this flag is set to true, the action of planning and executing is allowed to look around
     * (move sensors) if it seems that not enough information is available about the environment
     */
    public boolean look_around;

    /**
     * If this value is positive, the action of planning and executing is allowed to look around for
     * a maximum number of attempts; If the value is left as 0, the default value is used, as set
     * with dynamic_reconfigure
     */
    public Int32Message look_around_attempts = new Int32Message();

    /**
     * If set and if look_around is true, this value is used as the maximum cost allowed for a path
     * to be considered executable. If the cost of a path is higher than this value, more sensing or
     * a new plan needed. If left as 0.0 but look_around is true, then the default value set via
     * dynamic_reconfigure is used
     */
    public double max_safe_execution_cost;

    /**
     * If the plan becomes invalidated during execution, it is possible to have that plan recomputed
     * and execution restarted. This flag enables this functionality
     */
    public boolean replan;

    /** The maximum number of replanning attempts */
    public Int32Message replan_attempts = new Int32Message();

    /** The amount of time to wait in between replanning attempts (in seconds) */
    public double replan_delay;

    public PlanningOptionsMessage withPlanningSceneDiff(PlanningSceneMessage planning_scene_diff) {
        this.planning_scene_diff = planning_scene_diff;
        return this;
    }

    public PlanningOptionsMessage withPlanOnly(boolean plan_only) {
        this.plan_only = plan_only;
        return this;
    }

    public PlanningOptionsMessage withLookAround(boolean look_around) {
        this.look_around = look_around;
        return this;
    }

    public PlanningOptionsMessage withLookAroundAttempts(Int32Message look_around_attempts) {
        this.look_around_attempts = look_around_attempts;
        return this;
    }

    public PlanningOptionsMessage withMaxSafeExecutionCost(double max_safe_execution_cost) {
        this.max_safe_execution_cost = max_safe_execution_cost;
        return this;
    }

    public PlanningOptionsMessage withReplan(boolean replan) {
        this.replan = replan;
        return this;
    }

    public PlanningOptionsMessage withReplanAttempts(Int32Message replan_attempts) {
        this.replan_attempts = replan_attempts;
        return this;
    }

    public PlanningOptionsMessage withReplanDelay(double replan_delay) {
        this.replan_delay = replan_delay;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                planning_scene_diff,
                plan_only,
                look_around,
                look_around_attempts,
                max_safe_execution_cost,
                replan,
                replan_attempts,
                replan_delay);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (PlanningOptionsMessage) obj;
        return Objects.equals(planning_scene_diff, other.planning_scene_diff)
                && plan_only == other.plan_only
                && look_around == other.look_around
                && Objects.equals(look_around_attempts, other.look_around_attempts)
                && max_safe_execution_cost == other.max_safe_execution_cost
                && replan == other.replan
                && Objects.equals(replan_attempts, other.replan_attempts)
                && replan_delay == other.replan_delay;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "planning_scene_diff", planning_scene_diff,
                "plan_only", plan_only,
                "look_around", look_around,
                "look_around_attempts", look_around_attempts,
                "max_safe_execution_cost", max_safe_execution_cost,
                "replan", replan,
                "replan_attempts", replan_attempts,
                "replan_delay", replan_delay);
    }
}
