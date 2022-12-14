/*
 * Copyright 2022 jrosmoveit project
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
package pinorobotics.jros1moveit.impl.clients.executetrajectory;

import pinorobotics.jros1moveit.moveit_msgs.ExecuteTrajectoryGoalMessage;
import pinorobotics.jros1moveit.moveit_msgs.MoveGroupResultMessage;
import pinorobotics.jrosactionlib.JRosActionClient;
import pinorobotics.jrosmoveit.impl.clients.executetrajectory.AbstractExecuteTrajectoryClient;
import pinorobotics.jrosmoveit.moveit_msgs.ExecuteTrajectoryResultMessage;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class Ros1ExecuteTrajectoryClient
        extends AbstractExecuteTrajectoryClient<
                MoveGroupResultMessage,
                ExecuteTrajectoryGoalMessage,
                ExecuteTrajectoryResultMessage> {

    public Ros1ExecuteTrajectoryClient(
            JRosActionClient<ExecuteTrajectoryGoalMessage, ExecuteTrajectoryResultMessage>
                    executeTrajectoryActionClient) {
        super(executeTrajectoryActionClient);
    }

    @Override
    protected ExecuteTrajectoryGoalMessage createExecuteTrajectoryRequest(
            MoveGroupResultMessage plan) {
        var goal = new ExecuteTrajectoryGoalMessage();
        goal.trajectory = plan.planned_trajectory;
        return goal;
    }
}
