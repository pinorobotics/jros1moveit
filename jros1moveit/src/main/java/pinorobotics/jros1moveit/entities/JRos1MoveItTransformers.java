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
package pinorobotics.jros1moveit.entities;

import id.jros1messages.sensor_msgs.JointStateMessage;
import pinorobotics.robotstate.RobotState;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class JRos1MoveItTransformers {

    public RobotState toRobotState(JointStateMessage jointMessage) {
        return new RobotState(jointMessage.position);
    }
}
