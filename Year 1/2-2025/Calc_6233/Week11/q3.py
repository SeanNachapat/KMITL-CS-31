import numpy as np
from scipy.integrate import odeint
from scipy.interpolate import make_interp_spline
import matplotlib.pyplot as plt

def model(L, t):
    dLdt = np.exp(-0.05 * t) * np.cos(3 * t)
    return dLdt

L0 = 0
t = np.linspace(0, 100, 101)
L = odeint(model, L0, t).ravel()

t_fine = np.linspace(0, 100, 1000)
spline = make_interp_spline(t, L, k=3)
L_smooth = spline(t_fine)

plt.figure(figsize=(10, 6))
plt.plot(t, L, 'ro', markersize=4, label='Computed Loss')
plt.plot(t_fine, L_smooth, 'r-', linewidth=1.5, label='Smoothed Curve')
plt.xlabel('Training Epochs')
plt.ylabel('Loss Value')
plt.title('Loss Reduction in AI Model Training')
plt.legend()
plt.grid(True)
plt.xlim(0, 100)
plt.show()
