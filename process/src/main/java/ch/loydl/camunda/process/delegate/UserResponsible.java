package ch.loydl.camunda.process.delegate;

import ch.loydl.camunda.process.InstanceVariables;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
public class UserResponsible implements TaskListener {
    @Override
    public void notify(DelegateTask task) {
        task.setVariable(InstanceVariables.RESPONSIBLE, task.getAssignee());
    }
}
