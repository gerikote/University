package interfaces;

import enums.WageComparisonResult;
import people.AcademicStaff;
import people.Staff;

@FunctionalInterface
public interface IWageComparator<T extends Staff> {
    WageComparisonResult compareWages(T staff1, T staff2);
}
